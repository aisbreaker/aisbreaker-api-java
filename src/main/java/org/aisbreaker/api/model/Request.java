package org.aisbreaker.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Request {
    public List<Input> inputs;
    public String conversationState;
    public RequestedOptions requested;
    public Object internOptions;
    public String clientUser;
    @JsonIgnore
    public StreamProgressCallback streamProgressCallback;
    public boolean stream;
    /* TODO:
    public AbortSignal abortSignal;
    */


    //
    // Getters and Setters
    //

    public List<Input> getInputs() {
        return inputs;
    }
    public Request setInputs(List<Input> inputs) {
        this.inputs = inputs;
        return this;
    }
    public Request addInput(Input inputs) {
        if (this.inputs == null) {
            this.inputs = List.of(inputs);
        } else {
            this.inputs.add(inputs);
        }
        return this;
    }

    public String getConversationState() {
        return conversationState;
    }
    public Request setConversationState(String conversationState) {
        this.conversationState = conversationState;
        return this;
    }

    public RequestedOptions getRequested() {
        return requested;
    }
    public Request setRequested(RequestedOptions requested) {
        this.requested = requested;
        return this;
    }

    public Object getInternOptions() {
        return internOptions;
    }
    public Request setInternOptions(Object internOptions) {
        this.internOptions = internOptions;
        return this;
    }

    public String getClientUser() {
        return clientUser;
    }
    public Request setClientUser(String clientUser) {
        this.clientUser = clientUser;
        return this;
    }

    public StreamProgressCallback getStreamProgressCallback() {
        return streamProgressCallback;
    }
    public Request setStreamProgressCallback(StreamProgressCallback streamProgressCallback) {
        this.streamProgressCallback = streamProgressCallback;
        return this;
    }
    
    /* TODO:
    public AbortSignal getAbortSignal() {
        return abortSignal;
    }

    public void setAbortSignal(AbortSignal abortSignal) {
        this.abortSignal = abortSignal;
    }
    */

    public String toString() {
        return "Request{" +
                "inputs=" + inputs +
                ", conversationState='" + conversationState + '\'' +
                ", requested=" + requested +
                ", internOptions=" + internOptions +
                ", clientUser='" + clientUser + '\'' +
                ", streamProgressCallback=" + streamProgressCallback +
                '}';
    }
}
