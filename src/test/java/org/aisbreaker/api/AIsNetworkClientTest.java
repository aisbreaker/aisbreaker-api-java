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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class AIsNetworkClientTest {
    Logger logger = Logger.getLogger(AIsNetworkClientTest.class.getName());


    @Test
    public void testProcessBlockingIntegration() throws IOException, Exception {
        logger.info("testProcessBlockingIntegration ****************************************** l.i");

        // service configuration: select the service/serviceId you want to use
        AIsServiceProps serviceProps = new AIsServiceProps()
            .setServiceId("chat:dummy")
        
            //.setServiceId("chat:openai.com")
        
            //.setServiceId("chat:gemini.vertexai.google.com",
            //.setProject("<YOUR-GOOGLE-CLOUD-PROJECT>")          // optional for gemini.vertexai.google.com
            //.setLocation("<YOUR-GOOGLE-CLOUD-LOCATION>")        // optional for gemini.vertexai.google.com, e.g. "us-central1"
        
            //.setServiceId("chat:huggingface.co/<HF-ACCOUNT>/<HF-MODEL>")
            // e.g.:
            //.setServiceId("chat:huggingface.co/microsoft/DialoGPT-large")
        
            //.setServiceId("aisbreaker:mirror")
            //.setForward2ServiceProps(new AIsServiceProps()
            //    .setServiceId("chat:echo")
            //)
        ;
        
        // service initialization
        String aisbreakerServerURL =  null;//"https://api.demo.aisbreaker.org/";
        Auth auth = new Auth()
            // optionally, set your OpenAI API key:
            //.setSecret("sk-...")
        
            // optionally, set your Google Cloud (Vertext AI) API key:
            //.setSecret("googlecloud-account-json-base64_..")
        
            // optionally, set your Huggingface API key:
            //.setSecret("hf_...")
        
            // optionally, set your AIsBreaker API key:
            //.setSecret("aisbreaker_...")
        ;
        AIsService aisService =
            AIsBreaker.getAIsService(aisbreakerServerURL, serviceProps, auth); 

        
        // 1st question/prompt
        String question1 = "What is NodeJS?";
        logger.info("***** Question1 *****\n"+question1+"\n");

        // be able to receive callsbacks
        AtomicInteger callbackCounter = new AtomicInteger(0);
        StreamProgressCallback streamProgressCallback1 = new StreamProgressCallback() {
            @Override
            public void onProgress(ResponseEvent responseEvent) {
                try {
                    callbackCounter.incrementAndGet();
                    logger.info("testProcessBlockingIntegration.onProgress: " + JsonConverter.obj2Json(responseEvent));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // 1st request
        Request request1 = new Request()
            .addInput(new Input()
                .setText(new InputText()
                    .setRole("user")
                    .setContent(question1)
                )
            )
            .setStreamProgressCallback(streamProgressCallback1);

        // action and 1st answer
        ResponseFinal response1 = aisService.process(request1);
        logger.info("***** Answer1 *****\n"+response1.getOutputs().get(0).getText().getContent()+"\n");
            
        // check results
        Assertions.assertNotNull(response1, "Response is null");
        Assertions.assertNotNull(response1.getOutputs(), "No outputs found in answer");
        Assertions.assertTrue(response1.getOutputs().size() > 0, "No outputs found in answer");
        Assertions.assertNotNull(response1.getOutputs().get(0).getText(), "No text found in answer");

        // assert that the content contains a substring
        String textContent1 = response1.getOutputs().get(0).getText().getContent();
        Assertions.assertNotNull(textContent1, "No content found in answer");
        Assertions.assertTrue(textContent1.contains("DummyAssistantService"), "No 'DummyAssistantService' found in answer");
        Assertions.assertTrue(textContent1.contains("NodeJS"), "No 'NodeJS' found in answer");

        // assert that the callback was called
        Assertions.assertTrue(callbackCounter.get() > 0, "No callback was called");
        // as of 2024-04-02: 1st callback is called 22 times, but this can change over time
        //Assertions.assertEquals(callbackCounter.get(), 22, "Callback was not called 22 times");
        Assertions.assertTrue(callbackCounter.get() >= 10, "Callback was not called at least 10 times");
        Assertions.assertTrue(callbackCounter.get() <= 200, "Callback was called more than 200 times");

        /*
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
        */
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
