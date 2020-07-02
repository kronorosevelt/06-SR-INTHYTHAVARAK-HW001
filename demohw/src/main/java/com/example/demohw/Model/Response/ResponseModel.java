package com.example.demo.Model;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class BaseApiResponse<T> {
    private String message;
    private HttpStatus httpStatus;
    private Timestamp timestamp;
    private T data;
    public BaseApiResponse() {
    }

    public BaseApiResponse(String message, T data, HttpStatus httpStatus, Timestamp timestamp) {
        this.message = message;
        this.data = data;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


}
