package org.aisbreaker.api.model;

import java.util.List;

public class ClientRequest {
    public List<Input> inputs;
    public String text;
    public String conversationState;
    public RequestedOptions requested;
    public Object internOptions;
    public String clientUser;
    /* TODO: public StreamProgressFunction streamProgressFunction; */


    //
    // Getters and Setters
    //

    public List<Input> getInputs() {
        return inputs;
    }
    public ClientRequest setInputs(List<Input> inputs) {
        this.inputs = inputs;
        return this;
    }

    public String getText() {
        return text;
    }
    public ClientRequest setText(String text) {
        this.text = text;
        return this;
    }

    public String getConversationState() {
        return conversationState;
    }
    public ClientRequest setConversationState(String conversationState) {
        this.conversationState = conversationState;
        return this;
    }

    public RequestedOptions getRequested() {
        return requested;
    }
    public ClientRequest setRequested(RequestedOptions requested) {
        this.requested = requested;
        return this;
    }

    public Object getInternOptions() {
        return internOptions;
    }
    public ClientRequest setInternOptions(Object internOptions) {
        this.internOptions = internOptions;
        return this;
    }

    public String getClientUser() {
        return clientUser;
    }
    public ClientRequest setClientUser(String clientUser) {
        this.clientUser = clientUser;
        return this;
    }

    /* TODO:
    public StreamProgressFunction getStreamProgressFunction() {
        return streamProgressFunction;
    }
    public ClientRequest setStreamProgressFunction(StreamProgressFunction streamProgressFunction) {
        this.streamProgressFunction = streamProgressFunction;
        eturn this;
    }
    */

    public String toString() {
        return "ClientRequest{" +
                "inputs=" + inputs +
                ", text='" + text + '\'' +
                ", conversationState='" + conversationState + '\'' +
                ", requested=" + requested +
                ", internOptions=" + internOptions +
                ", clientUser='" + clientUser + '\'' +
                '}';
    }
}
