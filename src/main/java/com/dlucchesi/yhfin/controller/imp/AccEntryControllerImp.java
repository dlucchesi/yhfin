package com.dlucchesi.yhfin.controller.imp;

import com.dlucchesi.yhfin.convert.AccEntryDataConvert;
import com.dlucchesi.yhfin.model.AccEntry;
import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.data.AccEntryData;
import com.dlucchesi.yhfin.service.AccEntryService;
import com.dlucchesi.yhfin.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static java.util.Objects.isNull;

@Tag(name = "AccEntry", description = "AccountEntries APIs")
@RestController
@RequestMapping("/v1/accountentry")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AccEntryControllerImp implements com.dlucchesi.yhfin.controller.AccEntryController {

    final AccEntryService accEntryService;
    final AccountService accountService;
    final AccEntryDataConvert accEntryDataConvert;

    @Override
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable("id") Long id, HttpServletRequest request){
        log.debug("Id param: {}", id);
        if (!isNull(id) && id.compareTo(0L) > 0){
            Optional<AccEntry> opt = accEntryService.find(id);
            if (opt.isPresent()) {
                AccEntryData ret = accEntryDataConvert.convertToData(opt.get());
                log.debug("AccEntry found! Entry {}", ret);
                return ResponseEntity.ok(ret);
            } else {
                log.warn("AccEntry not found! Id {}", id);
                return ResponseEntity.ok().build();
            }
        } else {
            log.warn("Receive empty req from IP: {}", request.getRemoteAddr());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @Override
    @GetMapping
    @RequestMapping("/account/{id}")
    public ResponseEntity<?> findByAccount(@PathVariable("id") Long id, HttpServletRequest request){
        log.debug("Id param: {}", id);
        if (!isNull(id) && id.compareTo(0L) > 0){
            Optional<Account> opt = accountService.find(id);
            if (opt.isPresent()) {
                Account account = opt.get();
                Set<AccEntryData> entries = accEntryService.findByAccount(account).stream()
                        .map(accEntryDataConvert::convertToData)
                        .collect(java.util.stream.Collectors.toSet());
                log.debug("AccEntries found! Set size {}", entries.size());
                return ResponseEntity.ok(entries);
            } else {
                log.warn("AccEntries not found! AccountId {}", id);
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header(HttpHeaders.CONTENT_TYPE)
                        .body("Not found!");
            }
        } else {
            log.warn("Receive empty req from IP: {}", request.getRemoteAddr());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @Override
    @PostMapping
    public ResponseEntity<?> save(@RequestBody AccEntryData data, HttpServletRequest request){
        if (!isNull(data)){
            AccEntry entry = accEntryDataConvert.convertToImp(data);
            Optional<AccEntry> fromDb = accEntryService.save(entry);
            if (fromDb.isPresent()){
                AccEntryData ret = accEntryDataConvert.convertToData(fromDb.get());
                log.debug("AccEntry saved! Entry {}", ret);
                return ResponseEntity.ok(ret);
            } else {
                log.warn("AccEntry NOT saved! Data {}", entry);
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .header(HttpHeaders.CONTENT_TYPE)
                        .body("Not saved!");
            }
        } else {
            log.warn("Receive empty req from IP: {}", request.getRemoteAddr());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
