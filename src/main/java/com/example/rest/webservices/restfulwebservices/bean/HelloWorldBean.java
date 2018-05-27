package com.example.rest.webservices.restfulwebservices.bean;

public class HelloWorldBean {

    private final String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
