package com.dlucchesi.yhfin.repository;

import com.dlucchesi.yhfin.model.imp.AccountImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountImpRepository extends JpaRepository<AccountImp, Long> {

    AccountImp findByLabel(String Label);
    AccountImp findByNumber(String Number);

    Set<AccountImp> findAllByIsDeletedIsFalse();
    Set<AccountImp> findAllByIsDeletedIsTrue();
    Set<AccountImp> findAllByIsActiveIsTrue();
    Set<AccountImp> findAllByIsActiveIsFalse();
}
