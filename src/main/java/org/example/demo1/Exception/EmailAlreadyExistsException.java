package org.example.demo1.Exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("El email '" + email + "' ya está registrado");
    }
}
