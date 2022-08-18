package com.example.user.exception;

public class UserErrorResponse {
    private int Status;
    private String message;

    public UserErrorResponse(int status, String message) {
        Status = status;
        this.message = message;
    }

    public UserErrorResponse() {
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
