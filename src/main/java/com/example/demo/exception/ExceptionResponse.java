package com.example.demo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.StandardException;

@Setter
@Getter
@NoArgsConstructor
public class ExceptionResponse  {
    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
