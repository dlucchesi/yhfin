package com.dlucchesi.yhfin.service;

import com.dlucchesi.yhfin.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    User create();

    Set<User> find();

    Optional<User> find(Long id);

    Optional<User> findByUserId(String userId);

    Optional<User> save(User instance);

    Boolean delete(User entity, Boolean phys);
}
