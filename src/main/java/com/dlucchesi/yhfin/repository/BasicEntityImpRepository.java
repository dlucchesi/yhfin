package com.dlucchesi.yhfin.repository;

import com.dlucchesi.yhfin.model.imp.BasicEntityImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BasicEntityImpRepository extends JpaRepository<BasicEntityImp, Long> {

    Set<BasicEntityImp> findAllByIsDeletedIsFalseAndIsActiveIsTrue();

    Set<BasicEntityImp> findAllByIsDeletedIsFalse();
    Set<BasicEntityImp> findAllByIsDeletedIsTrue();
    Set<BasicEntityImp> findAllByIsActiveIsTrue();
    Set<BasicEntityImp> findAllByIsActiveIsFalse();
}
