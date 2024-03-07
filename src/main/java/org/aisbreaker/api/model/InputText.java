package org.aisbreaker.api.model;

/**
 * A text message sent to the AI service.
 */
public class InputText {
    /**
    * Role of the (input) message creator.
    */
    public /*InputTextRoleType*/String role;
    /**
    * The text message.
    */
    public String content;
    /**
    * 1.0 means normal prompt (default), 0.0 means ignore, -1.0 means negative prompt; >1.0 or <-1.0 applifies the prompt
    */
    public Double weight;


    public InputText() {
    }
    //public InputText(/*InputTextRoleType*/String role, String content) {
    //    this.role = role;
    //    this.content = content;
    //}
    //public InputText(/*InputTextRoleType*/String role, String content, Double weight) {
    //    this.role = role;
    //    this.content = content;
    //    this.weight = weight;
    //}

    //
    // Getters and Setters
    //

    public /*InputTextRoleType*/String getRole() {
        return role;
    }
    public InputText setRole(/*InputTextRoleType*/String role) {
        this.role = role;
        return this;
    }

    public String getContent() {
        return content;
    }
    public InputText setContent(String content) {
        this.content = content;
        return this;
    }

    public Double getWeight() {
        return weight;
    }
    public InputText setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public String toString() {
        return "InputText{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", weight=" + weight +
                '}';
    }
}

/*
enum InputTextRoleType {
    SYSTEM,
    USER
}
*/
