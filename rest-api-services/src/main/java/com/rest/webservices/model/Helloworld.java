package com.rest.webservices.model;

public class Helloworld {
    private String message;

    public Helloworld(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Helloworld{" +
                "message='" + message + '\'' +
                '}';
    }
}
