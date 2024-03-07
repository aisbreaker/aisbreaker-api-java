package org.aisbreaker.api.model;

/**
 * An image response from the AI service.
 */
public class OutputImage {
    /**
     * Index of the message in the request - 
     * relevant to distinguest multiple alternatives if request_ops.sample|number_of_alternative_responses>1.
     */
    public int index;
    /**
     * Role of the (output) message creator/input image.
     */
    public /*OutputImageRoleType*/String role;
    /**
     * The image, base64-encoded; either url or base64 must be set.
     */
    public String base64;
    /**
     * The image, url-encoded; either url or base64 must be set.
     */
    public String url;
    /**
     * If set to true, the image is still work in progress. If false, the image is the final response.
     */
    public boolean isProcessing;


    //
    // Getters and Setters
    //

    /**
     * Get the index of the message.
     *
     * @return the index of the message
     */
    public int getIndex() {
        return index;
    }
    /**
     * Set the index of the message.
     *
     * @param index the index of the message
     */
    public OutputImage setIndex(int index) {
        this.index = index;
        return this;
    }

    /**
     * Get the role of the message creator/input image.
     *
     * @return the role of the message creator/input image
     */
    public /*OutputImageRoleType*/String getRole() {
        return role;
    }
    /**
     * Set the role of the message creator/input image.
     *
     * @param role the role of the message creator/input image
     */
    public OutputImage setRole(/*OutputImageRoleType*/String role) {
        this.role = role;
        return this;
    }

    /**
     * Get the base64-encoded image.
     *
     * @return the base64-encoded image
     */
    public String getBase64() {
        return base64;
    }
    /**
     * Set the base64-encoded image.
     *
     * @param base64 the base64-encoded image
     */
    public OutputImage setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Get the url-encoded image.
     *
     * @return the url-encoded image
     */
    public String getUrl() {
        return url;
    }
    /**
     * Set the url-encoded image.
     *
     * @param url the url-encoded image
     */
    public OutputImage setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Check if the image is still work in progress.
     *
     * @return true if the image is still work in progress, false otherwise
     */
    public boolean isProcessing() {
        return isProcessing;
    }
    /**
     * Set whether the image is still work in progress.
     *
     * @param processing true if the image is still work in progress, false otherwise
     */
    public OutputImage setProcessing(boolean processing) {
        isProcessing = processing;
        return this;
    }

    public String toString() {
        return "OutputImage{" +
                "index=" + index +
                ", role='" + role + '\'' +
                ", base64='" + base64 + '\'' +
                ", url='" + url + '\'' +
                ", isProcessing=" + isProcessing +
                '}';
    }
}
