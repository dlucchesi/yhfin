package com.dlucchesi.yhfin.exceptions;

public class LoginInactiveUserException extends Exception {
    public LoginInactiveUserException(String message) {
        super(message);
    }
}
