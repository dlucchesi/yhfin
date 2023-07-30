package com.dlucchesi.yhfin.service;

import com.dlucchesi.yhfin.model.Account;

import java.util.Optional;
import java.util.Set;

public interface AccountService {
    Account create();

    Set<Account> find();

    Optional<Account> find(Long id);

    Optional<Account> save(Account instance);

    Boolean delete(Account entity, Boolean phys);
}
