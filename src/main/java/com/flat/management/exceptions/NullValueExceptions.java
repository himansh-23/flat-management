package com.flat.management.exceptions;


public class NullValueExceptions extends Exception{
    private String nullValue;
    private String ObjectName;

    public NullValueExceptions(String message, String objectName) {
        super(message);
        this.nullValue = message;
        ObjectName = objectName;
    }
}
