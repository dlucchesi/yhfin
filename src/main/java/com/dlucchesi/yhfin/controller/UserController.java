package com.dlucchesi.yhfin.controller;

import com.dlucchesi.yhfin.model.data.LoginData;
import com.dlucchesi.yhfin.model.imp.UserImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    @PostMapping
    @RequestMapping("/doLogin")
    ResponseEntity<?> doLogin(@RequestBody LoginData login, HttpServletRequest request);

    @GetMapping
    @RequestMapping("/login/{login}")
    ResponseEntity<?> findByLogin(@PathVariable("login") String login, HttpServletRequest request);

    @GetMapping
    @RequestMapping("/{id}")
    ResponseEntity<?> find(@PathVariable("id") Long id, HttpServletRequest request);

    @PostMapping
    ResponseEntity<?> save(@RequestBody UserImp user, HttpServletRequest request);
}
