package com.target.springQuizApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RestException extends RuntimeException{
    public RestException(String errorKeys) {
        super(errorKeys);
    }
}
