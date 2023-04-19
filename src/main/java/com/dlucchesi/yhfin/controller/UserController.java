package com.dlucchesi.yhfin.controller;

import com.dlucchesi.yhfin.exceptions.LoginDeletedUserException;
import com.dlucchesi.yhfin.exceptions.LoginInactiveUserException;
import com.dlucchesi.yhfin.exceptions.LoginNotFoundException;
import com.dlucchesi.yhfin.exceptions.LoginWrongPasswordException;
import com.dlucchesi.yhfin.model.data.LoginData;
import com.dlucchesi.yhfin.model.imp.UserImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    @PostMapping
    @RequestMapping("/doLogin")
    ResponseEntity<?> doLogin(@RequestBody LoginData login, HttpServletRequest request) throws LoginWrongPasswordException, LoginNotFoundException, LoginInactiveUserException, LoginDeletedUserException;

    @GetMapping
    @RequestMapping("/login/{login}")
    ResponseEntity<?> findByLogin(@PathVariable("login") String login, HttpServletRequest request);

    @GetMapping
    @RequestMapping("/{id}")
    ResponseEntity<?> find(@PathVariable("id") Long id, HttpServletRequest request);

    @PostMapping
    ResponseEntity<?> save(@RequestBody UserImp user, HttpServletRequest request);
}
