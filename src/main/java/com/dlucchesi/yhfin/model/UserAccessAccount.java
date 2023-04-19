package com.dlucchesi.yhfin.model;

public interface UserAccessAccount extends BasicEntity {
    @Override
    String toString();

    User getUser();

    Account getAccount();

    Boolean getIsOwner();

    java.util.Date getInsertDate();

    void setUser(User user);

    void setAccount(Account account);

    void setIsOwner(Boolean isOwner);

    void setInsertDate(java.util.Date insertDate);
}
