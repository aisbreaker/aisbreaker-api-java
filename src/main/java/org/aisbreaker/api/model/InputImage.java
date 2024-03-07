package org.aisbreaker.api.model;

/**
 * An image message sent to the AI service.
 */
public class InputImage {
    /**
     * Role of the (input) message creator/input image.
     * "user": The image to edit or to respond to. Must be a valid PNG file, less than 4MB, and square.
     * If mask is not provided, image must have transparency, which will be used as the mask.
     * "mask": An additional image whose fully transparent areas (e.g. where alpha is zero) indicate where image should be edited.
     * Must be a valid PNG file, less than 4MB, and have the same dimensions as image.
     */
    public /*InputImageRoleType*/ String role;

    /**
     * The image, base64-encoded; either url or base64 must be set.
     */
    public String base64;

    /**
     * The image, url-encoded; either url or base64 must be set.
     */
    public String url;


    //
    // Getters and Setters
    //

    public /*InputImageRoleType*/ String getRole() {
        return role;
    }
    public InputImage setRole(/*InputImageRoleType*/ String role) {
        this.role = role;
        return this;
    }

    public String getBase64() {
        return base64;
    }
    public InputImage setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public String getUrl() {
        return url;
    }
    public InputImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public String toString() {
        return "InputImage{" +
                "role='" + role + '\'' +
                ", base64='" + base64 + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

/*
enum InputImageRoleType {
    USER,
    MASK
}
*/
