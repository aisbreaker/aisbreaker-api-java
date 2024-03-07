package org.aisbreaker.api.model;

public class Service {
    public String serviceId;
    public String engine;
    public String url;


    //
    // Getters and Setters
    //

    public String getServiceId() {
        return serviceId;
    }
    public Service setServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getEngine() {
        return engine;
    }
    public Service setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getUrl() {
        return url;
    }
    public Service setUrl(String url) {
        this.url = url;
        return this;
    }

    public String toString() {
        return "Service{" +
                "serviceId='" + serviceId + '\'' +
                ", engine='" + engine + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
