package org.aisbreaker.api.model;

public class Message {
    public Input input;
    public Output output;


    //
    // Getters and Setters
    //

    public Input getInput() {
        return input;
    }
    public Message setInput(Input input) {
        this.input = input;
        return this;
    }

    public Output getOutput() {
        return output;
    }
    public Message setOutput(Output output) {
        this.output = output;
        return this;
    }

    public String toString() {
        return "Message{" +
                "input=" + input +
                ", output=" + output +
                '}';
    }
}
