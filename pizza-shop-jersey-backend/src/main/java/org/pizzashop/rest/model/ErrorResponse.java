package org.pizzashop.rest.model;

public class ErrorResponse {
    public int statusCode;
    public String message;
    public String description;

    public ErrorResponse(int statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }
}
