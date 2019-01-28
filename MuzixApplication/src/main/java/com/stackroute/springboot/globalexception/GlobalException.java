package com.stackroute.springboot.globalexception;

import com.stackroute.springboot.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {
    @ResponseStatus(value = HttpStatus.CONFLICT,reason = "User already exists")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handletrackAlreadyExistsException(TrackAlreadyExistsException e){    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Track does not exists")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handletrackNotFoundException(TrackNotFoundException e)
    {    }
}
