package org.aisbreaker.api.model;

import java.util.List;

public class Usage {
    public Service service;
    public Integer totalTokens;
    public Integer totalMilliseconds;
    public List<String> warnings;


    //
    // Getters and Setters
    //

    public Service getService() {
        return service;
    }
    public Usage setService(Service service) {
        this.service = service;
        return this;
    }

    public Integer getTotalTokens() {
        return totalTokens;
    }
    public Usage setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
        return this;
    }

    public Integer getTotalMilliseconds() {
        return totalMilliseconds;
    }
    public Usage setTotalMilliseconds(Integer totalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;
        return this;
    }

    public List<String> getWarnings() {
        return warnings;
    }
    public Usage setWarnings(List<String> warnings) {
        this.warnings = warnings;
        return this;
    }

    public String toString() {
        return "Usage{" +
                "service=" + service +
                ", totalTokens=" + totalTokens +
                ", totalMilliseconds=" + totalMilliseconds +
                ", warnings=" + warnings +
                '}';
    }
}
