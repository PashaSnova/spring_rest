package com.xen.spring.rest.exception_handling;

public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String info) {
        super(info);
    }
}
