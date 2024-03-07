package org.aisbreaker.api;

import org.aisbreaker.api.model.Request;

/**
 * Send a message to the AI service via the AIsBreaker server.
 */
public class AIsNetworkRequest {
    /**
     * The requested service, incl. serviceId.
     */
    public AIsServiceProps service;
    /**
     * The actual request
     */
    public Request request;


    //
    // Getters and Setters
    //

    public AIsServiceProps getService() {
        return service;
    }
    public AIsNetworkRequest setAIsServiceProps(AIsServiceProps service) {
        this.service = service;
        return this;
    }

    public Request getRequest() {
        return request;
    }
    public AIsNetworkRequest setRequest(Request request) {
        this.request = request;
        return this;
    }

    public String toString() {
        return "AIsNetworkRequest{" +
                "service=" + service +
                ", request=" + request +
                '}';
    }
}
