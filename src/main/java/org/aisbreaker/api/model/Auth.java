package org.aisbreaker.api.model;

/**
 * Authentication data to use a specific AI service.
 * 
 * Should not be logged for security reasons.
 */
public class Auth {
    public String secret;

    //
    // Getters and Setters
    //

    /**
     * If the service needs an access token/auth token/API key/access key it must be set here.
     */
    public String getSecret() {
        return secret;
    }

    public Auth setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String toString() {
        return "Auth{" +
                "secret='" + secret + '\'' +
                '}';
    }   
}