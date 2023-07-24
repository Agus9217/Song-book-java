package com.justinapp.Response;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessages {
    private String status;
    private String message;

    public ResponseMessages() {
    }

    public ResponseMessages(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
