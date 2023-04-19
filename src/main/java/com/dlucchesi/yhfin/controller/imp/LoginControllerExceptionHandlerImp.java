package com.dlucchesi.yhfin.controller.imp;

import com.dlucchesi.yhfin.controller.LoginControllerExceptionHandler;
import com.dlucchesi.yhfin.exceptions.LoginDeletedUserException;
import com.dlucchesi.yhfin.exceptions.LoginInactiveUserException;
import com.dlucchesi.yhfin.exceptions.LoginNotFoundException;
import com.dlucchesi.yhfin.exceptions.LoginWrongPasswordException;
import com.dlucchesi.yhfin.model.data.LoginData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LoginControllerExceptionHandlerImp extends ResponseEntityExceptionHandler
        implements LoginControllerExceptionHandler {

    @Override
    @ExceptionHandler(value = { LoginNotFoundException.class, LoginWrongPasswordException.class,
            LoginWrongPasswordException.class, LoginNotFoundException.class, LoginInactiveUserException.class,
            LoginDeletedUserException.class })
    public ResponseEntity<Object> handleWrongLogin(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Wrong login or password";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
