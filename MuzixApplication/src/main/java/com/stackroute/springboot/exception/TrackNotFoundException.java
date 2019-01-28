package com.stackroute.springboot.exception;

public class TrackNotFoundException extends Exception {

    private String msg;

    public TrackNotFoundException() {
    }

    public TrackNotFoundException(String msg) {
        super();
        this.msg = msg;
    }

}
