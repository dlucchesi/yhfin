package com.dlucchesi.yhfin.controller;

import com.dlucchesi.yhfin.model.imp.AccountImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AccountController {
    @GetMapping
    @RequestMapping("/{id}")
    ResponseEntity<?> find(@PathVariable("id") Long id, HttpServletRequest request);

    @PostMapping
    ResponseEntity<?> save(@RequestBody AccountImp acc, HttpServletRequest request);
}
