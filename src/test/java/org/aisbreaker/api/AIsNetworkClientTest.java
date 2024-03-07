package org.aisbreaker.api;

import org.aisbreaker.api.model.Auth;
import org.aisbreaker.api.model.Input;
import org.aisbreaker.api.model.InputText;
import org.aisbreaker.api.model.Request;
import org.aisbreaker.api.model.ResponseEvent;
import org.aisbreaker.api.model.ResponseFinal;
import org.aisbreaker.api.model.StreamProgressCallback;
import org.aisbreaker.api.utils.JsonConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class AIsNetworkClientTest {
    Logger logger = Logger.getLogger(AIsNetworkClientTest.class.getName());


    //@Test
    public void testProcessBlockingIntegration() throws IOException, Exception {
        System.out.println("testProcessBlockingIntegration ****************************************** S.o.p");
        logger.info("testProcessBlockingIntegration ****************************************** l.i");

        // Create a real request object
        AIsServiceProps serviceProps = new AIsServiceProps()
            .setServiceId("chat:dummy");
            //.serviceProps.setServiceId("chat:openai.com");

        Request request = new Request()
            //.setConversationState("test");
            .addInput(new Input()
                .setText(new InputText()
                    .setRole("user")
                    .setContent("What is JavaScript?")
                )
            );


        StreamProgressCallback streamProgressCallback = new StreamProgressCallback() {
            @Override
            public void onProgress(ResponseEvent responseEvent) {
                try {
                    logger.info("testProcessBlockingIntegration.onProgress: " + JsonConverter.obj2Json(responseEvent));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        request.setStreamProgressCallback(streamProgressCallback);
        logger.info("Request: " + request);

        // action 
        AIsService aisService =
            AIsBreaker.getAIsService(null, serviceProps, null); 
        //ResponseFinal responseFinal = aIsNetworkClient.processBlocking(request);
        Future<ResponseFinal> responseFinal = aisService.processNonBlocking(request);
        // sleep 5 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Response: " + JsonConverter.obj2Json(responseFinal.get()));
    }

    /*
     ** Generated Junit test(s) ... not ready yet
    //@Ignore
    //@Test
    public void testProcess() throws IOException {
        // Create a mock Request object
        Request request = Mockito.mock(Request.class);

        // Create a mock ResponseFinal object
        ResponseFinal responseFinal = Mockito.mock(ResponseFinal.class);

        // Create a mock AIsNetworkClient object
        AIsNetworkClient aIsNetworkClient = Mockito.mock(AIsNetworkClient.class);

        // Set up the mock behavior for processUnprotected method
        Mockito.when(aIsNetworkClient.processUnprotected(request, "context"))
                .thenReturn(CompletableFuture.completedFuture(responseFinal));

        try {
            // Call the process method
            CompletableFuture<ResponseFinal> result = aIsNetworkClient.processNonBlocking(request);

            // Verify that the processUnprotected method was called with the correct arguments
            Mockito.verify(aIsNetworkClient).processUnprotected(request, "context");

            // Verify that the returned CompletableFuture is the same as the one returned by processUnprotected
            Assertions.assertEquals(result, CompletableFuture.completedFuture(responseFinal));
        } catch (IOException e) {
            Assertions.fail("Unexpected IOException occurred");
        } catch (RuntimeException e) {
            Assertions.fail("Unexpected RuntimeException occurred");
        }
    }
    */
}