package com.dlucchesi.yhfin.controller;

import com.dlucchesi.yhfin.model.data.AccEntryData;
import com.dlucchesi.yhfin.model.imp.AccEntryImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AccEntryController {
    @GetMapping
    @RequestMapping("/{id}")
    ResponseEntity<?> find(@PathVariable("id") Long id, HttpServletRequest request);

    @GetMapping
    @RequestMapping("/account/{id}")
    ResponseEntity<?> findByAccount(@PathVariable("id") Long id, HttpServletRequest request);

    @PostMapping
    ResponseEntity<?> save(@RequestBody AccEntryData data, HttpServletRequest request);
}
