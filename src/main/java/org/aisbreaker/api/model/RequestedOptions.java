package org.aisbreaker.api.model;

public class RequestedOptions {
    public RequestedMediaText text;
    public RequestedMediaImage image;
    public Object audio;
    public Object video;
    public Integer samples;
    public Integer maxTotalTokens;


    //
    // Getters and Setters
    //

    public RequestedMediaText getText() {
        return text;
    }
    public RequestedOptions setText(RequestedMediaText text) {
        this.text = text;
        return this;
    }

    public RequestedMediaImage getImage() {
        return image;
    }
    public RequestedOptions setImage(RequestedMediaImage image) {
        this.image = image;
        return this;
    }

    public Object getAudio() {
        return audio;
    }
    public RequestedOptions setAudio(Object audio) {
        this.audio = audio;
        return this;
    }

    public Object getVideo() {
        return video;
    }
    public RequestedOptions setVideo(Object video) {
        this.video = video;
        return this;
    }

    public Integer getSamples() {
        return samples;
    }
    public RequestedOptions setSamples(Integer samples) {
        this.samples = samples;
        return this;
    }

    public Integer getMaxTotalTokens() {
        return maxTotalTokens;
    }
    public RequestedOptions setMaxTotalTokens(Integer maxTotalTokens) {
        this.maxTotalTokens = maxTotalTokens;
        return this;
    }

    public String toString() {
        return "RequestedOptions{" +
                "text=" + text +
                ", image=" + image +
                ", audio=" + audio +
                ", video=" + video +
                ", samples=" + samples +
                ", maxTotalTokens=" + maxTotalTokens +
                '}';
    }
}
