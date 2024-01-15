package com.example.demo.exception;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MovieException extends RuntimeException {
}
