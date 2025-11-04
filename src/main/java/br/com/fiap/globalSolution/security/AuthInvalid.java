package br.com.fiap.globalSolution.security;

import org.springframework.http.HttpStatus;

public class AuthInvalid
{
    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthInvalid(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public AuthInvalid() {
    }
}
