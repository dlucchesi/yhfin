package com.dlucchesi.yhfin.model;

public interface AccEntry extends BasicEntity {
    @Override
    String toString();

    String getLabel();

    String getDescription();

    java.util.Date getEntryDate();

    Double getAmount();

    EntryType getType();

    void setLabel(String label);

    void setDescription(String description);

    void setEntryDate(java.util.Date entryDate);

    void setAmount(Double amount);

    void setType(EntryType type);

    Account getAccount();

    void setAccount(Account account);
}
