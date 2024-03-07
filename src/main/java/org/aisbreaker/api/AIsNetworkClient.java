package org.aisbreaker.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpTimeoutException;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.aisbreaker.api.model.Auth;
import org.aisbreaker.api.model.Request;
import org.aisbreaker.api.model.ResponseEvent;
import org.aisbreaker.api.model.ResponseFinal;
import org.aisbreaker.api.utils.JsonConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// AIsNetworkClient: Service (client) to access a remote AIsBreaker (proxy) server.
//

class AIsNetworkClient implements AIsService {
    static String aisDefaultURL = "https://api.demo.aisbreaker.org/api/v1/process"; // "http://localhost:3000/api/v1/process";
    // https://app.beeceptor.com/console/x1313
    // static String aisDefaultURL =
    // "https://x1313.free.beeceptor.com/api/v1/process"; //
    // "http://localhost:3000/api/v1/process";
    static boolean DEBUG = true;

    static Logger logger = LoggerFactory.getLogger(AIsNetworkClient.class);

    // provided properties
    protected String aisURL;
    protected AIsServiceProps serviceProps;
    protected Auth auth;

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public AIsNetworkClient(String aisURL, AIsServiceProps serviceProps, Auth auth) {
        if (aisURL == null || aisURL.isEmpty()) {
            this.aisURL = aisDefaultURL;
        } else {
            this.aisURL = aisURL;
        }
        this.serviceProps = serviceProps;
        this.auth = auth;
    }

    /**
     * Let the service do its work. Blocking.
     */
    public ResponseFinal process(Request request) throws AIsError {
        // preparation for logging and exceptions
        String context = this.getContext(request) + ".process()";

        try {
            // action
            return processNonBlocking(request).get();

        } catch (InterruptedException e) {
            // error handling
            logger.error(context + " - InterruptedException: ", e);
            throw new AIsError("Request interrupted", e);
        } catch (ExecutionException e) {
            // error handling
            logger.error(context + " - ExecutionException: ", e);
            throw new AIsError("Request execution failed", e);
        }
    }

    /**
     * Let the service do its work. Non-Blocking.
     */
    public CompletableFuture<ResponseFinal> processNonBlocking(Request request) throws AIsError {
        // preparation for logging and exceptions
        String context = this.getContext(request) + ".processNonBlocking()";

        try {
            logger.debug(context + " START");

            // action
            // ResponseFinalOrAIsError responseFinalOrAIsError = processFunction();
            // check that all required fields are present
            // TODO: this.checkRequest(request, context);

            // do the work
            CompletableFuture<ResponseFinal> responseFinalOrAIsError = this.processUnprotected(request, context);

            /*
             * TODO:
             * // process the final result
             * if (responseFinalOrAIsError == null) {
             * throw new AIsError(context + " - No final response",
             * HttpStatusCodes.ERROR_444_No_Response);
             * } else if (responseFinalOrAIsError instanceof AIsError) {
             * // re-throw the error unchanged
             * throw (AIsError) responseFinalOrAIsError;
             * } else {
             * // return the response
             * logger.silly(context + " END with successful responseFinal: " +
             * responseFinalOrAIsError);
             * return responseFinalOrAIsError;
             * }
             */
            return responseFinalOrAIsError;

        } catch (IOException error) {
            // error handling
            logger.error(context + " - IOException: ", error);
            throw new AIsError(context + " - IOException", error);
        } catch (RuntimeException error) {
            // error handling
            logger.error(context + " - RuntimeException: ", error);
            throw new AIsError(context + " - RuntimeException", error);
        }
    }

    protected String getContext(Request request) {
        return "AIsNetworkClient(" + this.serviceProps.getServiceId() + ")";
    }

    /**
     * Do the work of process()
     * without the need to care about all error handling.
     * 
     * @param request the request to process
     * @param context optional context information/description/message prefix
     *                for logging and for error messages
     * @returns The final result.
     *          In the case of an error it returns an AIsError OR throws an AIError
     *          or general Error.
     */
    public CompletableFuture<ResponseFinal> processUnprotected(Request request, String context)
            throws IOException {
        // prepare remote access
        boolean isStreamingRequested = (request.getStreamProgressCallback() != null);
        request.stream = isStreamingRequested;

        AIsNetworkRequest aisNetworkRequest = new AIsNetworkRequest();
        aisNetworkRequest.setAIsServiceProps(this.serviceProps);
        aisNetworkRequest.setRequest(request);
        logger.info(context + " - aisNetworkRequest: " + JsonConverter.obj2Json(aisNetworkRequest));

        if (!isStreamingRequested) {
            // no streaming (simple)
            return processNonStreamingRequest(this.aisURL, request, aisNetworkRequest, context);
        } else {
            // streaming (more complex)
            return processStreamingRequest(this.aisURL, request, aisNetworkRequest, context);
        }
    }

    /**
     * Process a non-streaming request.
     */
    private CompletableFuture<ResponseFinal> processNonStreamingRequest(
            String url,
            Request request,
            AIsNetworkRequest aisNetworkRequest,
            String context) throws IOException {
        String bodyStr = JsonConverter.obj2Json(aisNetworkRequest);
        logger.info("bodyStr: " + bodyStr);
        byte[] bodyBytes = JsonConverter.obj2JsonBytes(aisNetworkRequest);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers(this.getHttpRequestHeaders("application/json", this.auth))
                // .POST(BodyPublishers.ofString(bodyStr))
                .POST(BodyPublishers.ofByteArray(bodyBytes))
                .build();

        return httpClient.sendAsync(httpRequest, BodyHandlers.ofString())
                .thenApply(response -> {
                    int statusCode = response.statusCode();
                    String responseBody = response.body();

                    logger.info(context + " - HTTP response: " + statusCode + " " + responseBody);

                    if (statusCode >= 200 && statusCode < 300) {
                        try {
                            return JsonConverter.json2Obj(responseBody, ResponseFinal.class);
                        } catch (IOException e) {
                            throw new AIsError("Failed to parse response: " + e, 400); // TODO
                        }
                    } else {
                        throw new AIsError("HTTP request failed with status code: ", statusCode);
                    }
                });
    }

    /**
     * Process a streaming request.
     */
    private CompletableFuture<ResponseFinal> processStreamingRequest(
            String url,
            Request request,
            AIsNetworkRequest aisNetworkRequest,
            String context) throws IOException {
        String bodyStr = JsonConverter.obj2Json(aisNetworkRequest);
        logger.info("bodyStr: " + bodyStr);
        byte[] bodyBytes = JsonConverter.obj2JsonBytes(aisNetworkRequest);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers(this.getHttpRequestHeaders("text/event-stream", this.auth))
                // .POST(BodyPublishers.ofString(bodyStr))
                .POST(BodyPublishers.ofByteArray(bodyBytes))
                .build();

        CompletableFuture<ResponseFinal> responseFuture = new CompletableFuture<>();

        final String EVENT_ = "event: ";
        final String DATA_ = "data: ";
        final String PROGRESS = "progress";
        final String FINAL = "final";

        httpClient.sendAsync(httpRequest, BodyHandlers.ofLines())
                .thenAccept(response -> {
                    logger.info("response: " + response);
                    // HttpHeaders headers = response.headers();
                    class StringHolder {
                        String eventName = "";
                    }
                    StringHolder stringHolder = new StringHolder();
                    response.body().forEach(line -> {
                        logger.info("response line: " + line);
                        // Process each line of the streaming response
                        if (line.startsWith(EVENT_)) {
                            stringHolder.eventName = line.substring(EVENT_.length());
                            return;
                        } else if (line.startsWith(DATA_)) {
                            String lineData = line.substring(DATA_.length());
                            if (PROGRESS.equals(stringHolder.eventName)) {
                                logger.info("response lineData ('progress'): " + lineData);
                                // parse the line as JSON to ResponseEvent
                                try {
                                    ResponseEvent responseEvent = JsonConverter.json2Obj(lineData, ResponseEvent.class);
                                    // notify stream result
                                    request.getStreamProgressCallback().onProgress(responseEvent);
                                    // update final result
                                    // TODO
                                } catch (IOException e) {
                                    responseFuture
                                            .completeExceptionally(new AIsError("Failed to parse response: " + e, 400)); // TODO
                                }
                            } else if (FINAL.equals(stringHolder.eventName)) {
                                logger.info("response lineData ('final'): " + lineData);
                                // parse the line as JSON to ResponseFinal
                                try {
                                    ResponseFinal responseFinal = JsonConverter.json2Obj(lineData, ResponseFinal.class);
                                    // update final result
                                    responseFuture.complete(responseFinal);
                                    return;
                                } catch (IOException e) {
                                    responseFuture
                                            .completeExceptionally(new AIsError("Failed to parse response: " + e, 400)); // TODO
                                }
                            } else {
                                logger.info("response lineData ('" + stringHolder.eventName + "') ignored: '" + lineData
                                        + "'");
                                return;
                            }
                        } else {
                            // line without relevant data ignored
                            logger.warn("response line ignored: " + line);
                            return;
                        }
                    });
                })
                .exceptionally(ex -> {
                    if (ex instanceof HttpTimeoutException || ex instanceof HttpConnectTimeoutException) {
                        responseFuture.completeExceptionally(new TimeoutException("Request timed out"));
                    } else {
                        responseFuture.completeExceptionally(ex);
                    }
                    return null;
                });

        return responseFuture;
    }

    //
    // helper methods
    //

    /**
     * ¶eturn the HTTP request headers: two array elemments per header, name and
     * value, e.g. "Content-Type", "application/json"
     */
    protected String[] getHttpRequestHeaders(String accept, Auth auth) {
        List<String> headers = new ArrayList<String>();
        headers.add("Content-Type");
        headers.add("application/json");
        headers.add("Accept");
        headers.add(accept);
        if (auth != null && auth.getSecret() != null && !(auth.getSecret().isEmpty())) {
            headers.add("Authorization");
            headers.add("Bearer " + auth.getSecret());
        }
        return headers.toArray(new String[0]);
    }

}
