package org.aisbreaker.api.model;

public class RequestedMediaImage {
    public Integer width;
    public Integer height;
    public /*RequestedMediaImageDeliveryType*/String delivery;
    public /*RequestedMediaImageFormatType*/String format;


    //
    // Getters and Setters
    //
    public Integer getWidth() {
        return width;
    }
    public RequestedMediaImage setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }
    public RequestedMediaImage setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public /*RequestedMediaImageDeliveryType*/String getDelivery() {
        return delivery;
    }
    public RequestedMediaImage setDelivery(/*RequestedMediaImageDeliveryType*/String delivery) {
        this.delivery = delivery;
        return this;
    }

    public /*RequestedMediaImageFormatType*/String getFormat() {
        return format;
    }
    public RequestedMediaImage setFormat(/*RequestedMediaImageFormatType*/String format) {
        this.format = format;
        return this;
    }

    public String toString() {
        return "RequestedMediaImage{" +
                "width=" + width +
                ", height=" + height +
                ", delivery='" + delivery + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}

/*
public enum RequestedMediaImageDeliveryType {
    URL,
    BASE64
}

public enum RequestedMediaImageFormatType {
    JPEG,
    PNG,
    GIF
}
*/