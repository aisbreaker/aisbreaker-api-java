package org.aisbreaker.api.model;

import java.util.List;

public class ResponseEvent {
    public List<Output> outputs;
    public Object internResponse;


    //
    // Getters and Setters
    //

    public List<Output> getOutputs() {
        return outputs;
    }
    public ResponseEvent setOutputs(List<Output> outputs) {
        this.outputs = outputs;
        return this;
    }

    public Object getInternResponse() {
        return internResponse;
    }
    public ResponseEvent setInternResponse(Object internResponse) {
        this.internResponse = internResponse;
        return this;
    }

    public String toString() {
        return "ResponseEvent{" +
                "outputs=" + outputs +
                ", internResponse=" + internResponse +
                '}';
    }
}
