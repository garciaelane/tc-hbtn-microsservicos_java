package com.example.user.exception;

import java.util.Objects;

public class UserErrorResponse {

    private int status;
    private String message;

    public UserErrorResponse() {
    }

    public UserErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserErrorResponse that = (UserErrorResponse) o;
        return status == that.status && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }
}
