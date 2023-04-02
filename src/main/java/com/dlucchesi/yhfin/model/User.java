package com.dlucchesi.yhfin.model;

public interface User extends BasicEntity {
    @Override
    String toString();

    String getUserId();

    String getPassword();

    void setUserId(String userId);

    void setPassword(String password);
}
