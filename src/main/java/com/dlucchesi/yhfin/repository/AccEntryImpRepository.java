package com.dlucchesi.yhfin.repository;

import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.imp.AccEntryImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AccEntryImpRepository extends JpaRepository<AccEntryImp, Long> {

    AccEntryImp findByLabel(String Label);
    Set<AccEntryImp> findByAccount(Account account);

    Set<AccEntryImp> findAllByIsDeletedIsFalse();
    Set<AccEntryImp> findAllByIsDeletedIsTrue();
    Set<AccEntryImp> findAllByIsActiveIsTrue();
    Set<AccEntryImp> findAllByIsActiveIsFalse();
}
