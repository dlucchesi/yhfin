package com.dlucchesi.yhfin.repository;

import com.dlucchesi.yhfin.model.imp.UserImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserImpRepository extends JpaRepository<UserImp, Long> {

    UserImp findByUserId(String userId);

//    Set<UserImp> findAllByIsDeletedIsFalseAndIsActiveIsTrue();

    Set<UserImp> findAllByIsDeletedIsFalse();
    Set<UserImp> findAllByIsDeletedIsTrue();
    Set<UserImp> findAllByIsActiveIsTrue();
    Set<UserImp> findAllByIsActiveIsFalse();
}
