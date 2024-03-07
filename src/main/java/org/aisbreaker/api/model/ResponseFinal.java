package org.aisbreaker.api.model;

import java.util.List;

public class ResponseFinal {
    public List<Output> outputs;
    public String conversationState;
    public Usage usage;
    public Object internResponse;


    //
    // Getters and Setters
    //

    public List<Output> getOutputs() {
        return outputs;
    }
    public ResponseFinal setOutputs(List<Output> outputs) {
        this.outputs = outputs;
        return this;
    }

    public String getConversationState() {
        return conversationState;
    }
    public ResponseFinal setConversationState(String conversationState) {
        this.conversationState = conversationState;
        return this;
    }

    public Usage getUsage() {
        return usage;
    }
    public ResponseFinal setUsage(Usage usage) {
        this.usage = usage;
        return this;
    }

    public Object getInternResponse() {
        return internResponse;
    }
    public ResponseFinal setInternResponse(Object internResponse) {
        this.internResponse = internResponse;
        return this;
    }

    public String toString() {
        return "ResponseFinal{" +
                "outputs=" + outputs +
                ", conversationState='" + conversationState + '\'' +
                ", usage=" + usage +
                ", internResponse=" + internResponse +
                '}';
    }
}
