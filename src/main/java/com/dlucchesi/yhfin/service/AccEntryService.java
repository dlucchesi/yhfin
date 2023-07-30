package com.dlucchesi.yhfin.service;

import com.dlucchesi.yhfin.model.AccEntry;
import com.dlucchesi.yhfin.model.Account;

import java.util.Optional;
import java.util.Set;

public interface AccEntryService {
    AccEntry create();

    Set<AccEntry> find();

    Optional<AccEntry> find(Long id);

    Set<AccEntry> findByAccount(Account account);

    Optional<AccEntry> save(AccEntry instance);

    Boolean delete(AccEntry entity, Boolean phys);
}
