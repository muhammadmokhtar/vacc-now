package com.digitalfactory.vaccnow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TimeScheduleNotAvailableException extends RuntimeException {
    public TimeScheduleNotAvailableException(String message) {
        super(message);
    }

}
