package org.aisbreaker.api.model;

/**
 * A message sent to the AI service. 
 * 
 * Hint: This is usually NOT a response to a previous request/reponse of the same conversation,
 *       because previous messages are stored in the conversationState.
 */
public class Input {
    public InputText text;
    public InputImage image;
    public Object audio;
    public Object video;


    //
    // Getters and Setters
    //
    
    /**
     * An input message; either text or image or audio or video must be set.
     */
    public InputText getText() {
        return text;
    }
    /**
     * An input message; either text or image or audio or video must be set.
     */
    public Input setText(InputText text) {
        this.text = text;
        return this;
    }

    /**
     * An input message; either text or image or audio or video must be set.
     */
    public InputImage getImage() {
        return image;
    }
    /**
     * An input message; either text or image or audio or video must be set.
     */
    public Input setImage(InputImage image) {
        this.image = image;
        return this;
    }

    /**
     * An input message; either text or image or audio or video must be set.
     */
    public Object getAudio() {
        return audio;
    }
    /**
     * An input message; either text or image or audio or video must be set.
     */
    public Input setAudio(Object audio) {
        this.audio = audio;
        return this;
    }

    /**
     * An input message; either text or image or audio or video must be set.
     */
    public Object getVideo() {
        return video;
    }
    /**
     * An input message; either text or image or audio or video must be set.
     */
    public Input setVideo(Object video) {
        this.video = video;
        return this;
    }

    public String toString() {
        return "Input{" +
                "text=" + text +
                ", image=" + image +
                ", audio=" + audio +
                ", video=" + video +
                '}';
    }
}
