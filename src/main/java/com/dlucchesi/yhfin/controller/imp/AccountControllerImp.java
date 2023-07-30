package com.dlucchesi.yhfin.controller.imp;

import com.dlucchesi.yhfin.convert.AccountDataConvert;
import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.data.AccountData;
import com.dlucchesi.yhfin.model.imp.AccountImp;
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

import static java.util.Objects.isNull;

@Tag(name = "Account", description = "Accounts APIs")
@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AccountControllerImp implements com.dlucchesi.yhfin.controller.AccountController {

    final AccountService accountService;
    final AccountDataConvert accountDataConvert;

    @Override
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable("id") Long id, HttpServletRequest request){
        log.debug("Id param: {}", id);
        if (!isNull(id) && id.compareTo(0L) > 0){
            Optional<Account> opt = accountService.find(id);
            if (opt.isPresent()) {
                Account account = opt.get();
                log.debug("Account found! Acc {}", account);
                AccountData ret = accountDataConvert.convertToData(account);
                return ResponseEntity.ok(ret);
            } else {
                log.warn("Account not found! Id {}", id);
                return ResponseEntity.ok().build();
            }
        } else {
            log.warn("Receive empty req from IP: {}", request.getRemoteAddr());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @Override
    @PostMapping
    public ResponseEntity<?> save(@RequestBody AccountImp acc, HttpServletRequest request){
        if (!isNull(acc)){
            Optional<Account> fromDb = accountService.save(acc);
            if (fromDb.isPresent()){
                Account account = fromDb.get();
                log.debug("Account saved! Acc {}", account);
                AccountData ret = accountDataConvert.convertToData(account);
                return ResponseEntity.ok(ret);
            } else {
                log.warn("Account NOT saved! Data {}", acc);
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
