package org.aisbreaker.api.model;

public class Output {
    public OutputText text;
    public OutputImage image;
    public Object audio;
    public Object video;

    //
    // Getters and Setters
    //

    public OutputText getText() {
        return text;
    }
    public Output setText(OutputText text) {
        this.text = text;
        return this;
    }

    public OutputImage getImage() {
        return image;
    }
    public Output setImage(OutputImage image) {
        this.image = image;
        return this;
    }

    public Object getAudio() {
        return audio;
    }
    public Output setAudio(Object audio) {
        this.audio = audio;
        return this;
    }

    public Object getVideo() {
        return video;
    }
    public Output setVideo(Object video) {
        this.video = video;
        return this;
    }

    public String toString() {
        return "Output{" +
                "text=" + text +
                ", image=" + image +
                ", audio=" + audio +
                ", video=" + video +
                '}';
    }
}
