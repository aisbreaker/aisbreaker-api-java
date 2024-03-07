package org.aisbreaker.api.model;

public class OutputText {
    public int index;
    public /*OutputTextRoleType*/String role;
    public String content;
    public boolean isDelta;
    public boolean isProcessing;


    //
    // Getters and Setters
    //

    public int getIndex() {
        return index;
    }
    public OutputText setIndex(int index) {
        this.index = index;
        return this;
    }

    public /*OutputTextRoleType*/String getRole() {
        return role;
    }
    public OutputText setRole(/*OutputTextRoleType*/String role) {
        this.role = role;
        return this;
    }

    public String getContent() {
        return content;
    }
    public OutputText setContent(String content) {
        this.content = content;
        return this;
    }

    public boolean isDelta() {
        return isDelta;
    }
    public OutputText setDelta(boolean delta) {
        isDelta = delta;
        return this;
    }

    public boolean isProcessing() {
        return isProcessing;
    }
    public OutputText setProcessing(boolean processing) {
        isProcessing = processing;
        return this;
    }

    public String toString() {
        return "OutputText{" +
                "index=" + index +
                ", role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", isDelta=" + isDelta +
                ", isProcessing=" + isProcessing +
                '}';
    }
}

/*
public enum OutputTextRoleType {
    ASSISTANT
}
*/