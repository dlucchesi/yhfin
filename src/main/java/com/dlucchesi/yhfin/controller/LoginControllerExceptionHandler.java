package com.dlucchesi.yhfin.controller;

import com.dlucchesi.yhfin.exceptions.LoginNotFoundException;
import com.dlucchesi.yhfin.exceptions.LoginWrongPasswordException;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public interface LoginControllerExceptionHandler extends MessageSourceAware {
    @ExceptionHandler(value = {LoginNotFoundException.class, LoginWrongPasswordException.class})
    ResponseEntity<Object> handleWrongLogin(RuntimeException ex, WebRequest request);
}
