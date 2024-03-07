package org.aisbreaker.api.model;

public class RequestedMediaText {
    public String language;
    public int maxChars;

    //
    // Getters and Setters
    //
    
    public String getLanguage() {
        return language;
    }
    public RequestedMediaText setLanguage(String language) {
        this.language = language;
        return this;
    }

    public int getMaxChars() {
        return maxChars;
    }
    public RequestedMediaText setMaxChars(int maxChars) {
        this.maxChars = maxChars;
        return this;
    }

    public String toString() {
        return "RequestedMediaText{" +
                "language='" + language + '\'' +
                ", maxChars=" + maxChars +
                '}';
    }
}
