package com.stackroute.springboot.exception;

public class TrackAlreadyExistsException extends Exception{

    private String message;

    public TrackAlreadyExistsException(){

    }

    public TrackAlreadyExistsException(String message) {
        super();
        this.message = message;
    }
}
