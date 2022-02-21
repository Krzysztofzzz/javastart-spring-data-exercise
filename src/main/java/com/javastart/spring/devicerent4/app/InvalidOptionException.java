package com.javastart.spring.devicerent4.app;

class InvalidOptionException extends RuntimeException {
    InvalidOptionException() {
        super("Opcja nie istnieje");
    }
}