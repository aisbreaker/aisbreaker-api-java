package org.aisbreaker.api;


import org.aisbreaker.api.model.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Class to create and manage service APIs.
 *
 * Starting point for app code / for code using the AIs framework.
 */
public class AIsBreaker {
    private static AIsBreaker defaultAIsBreaker;

    static Logger logger = LoggerFactory.getLogger(AIsBreaker.class);

    private AIsBreaker() {
    }

    public static AIsBreaker getInstance() {
        if (defaultAIsBreaker == null) {
            defaultAIsBreaker = new AIsBreaker();
        }
        return defaultAIsBreaker;
    }

    /**
     * Get a service API for the given props (which include the serviceId)
     * from a remote AIsBreaker server.
     *
     * Inclusive all default filters. They will be added here during creation.
     *
     * @param aisbreakerServerURL URL of the remote AIsBreaker server
     * @param props               of the requested service (incl. props.serviceId)
     * @param auth                optional auth object
     * @return AIsService
     */
    public AIsService _getAIsService(String aisbreakerServerURL, AIsServiceProps serviceProps, Auth auth) {
        AIsService aisService = 
            new AIsNetworkClient(aisbreakerServerURL, serviceProps, auth);
        return aisService;
    }

    public static AIsService getAIsService(String aisbreakerServerURL, AIsServiceProps props, Auth auth) {
        return AIsBreaker.getInstance()._getAIsService(aisbreakerServerURL, props, auth);
    }

    public boolean _pingAIsService(String aisbreakerServerURL) {
        try {
            String url = aisbreakerServerURL + "/api/v1/ping";

            // make a simple HTTP GET request to ping,
            // preparation
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
            // action
            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

            // check that the response
            if (response.statusCode() == 200) {
                if (response.body().contains("pong")) {
                    // success
                    return true;
                }
                logger.warn("pingRemoteAIsService('" + aisbreakerServerURL + "') failed with body: " + response.body());
                return false;
            } else {
                // error
                logger.warn("pingRemoteAIsService('" + aisbreakerServerURL + "') failed status code: " + response.statusCode());
                return false;
            }
        } catch (Exception e) {
            logger.warn("pingRemoteAIsService('" + aisbreakerServerURL + "') failed with exception: " + e, e);
            return false;
        }
    }

    public static boolean pingAIsService(String aisbreakerServerURL) {
        return AIsBreaker.getInstance()._pingAIsService(aisbreakerServerURL);
    }
}
