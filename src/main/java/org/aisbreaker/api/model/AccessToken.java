package org.aisbreaker.api.model;


/**
 * If the service needs an access token/auth token/API key/access key it must be set here.
 */
public class AccessToken extends Auth {
    public String secret;


    //
    // Getters and Setters
    //
    
    public String getSecret() {
        return secret;
    }

    public AccessToken setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String toString() {
        return "AccessToken{" +
                "secret='" + secret + '\'' +
                '}';
    }
}
