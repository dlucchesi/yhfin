package com.dlucchesi.yhfin.model;

public interface Account extends BasicEntity {
    @Override
    String toString();

    String getLabel();

    String getDescription();

    String getNumber();

    String getType();

    void setLabel(String label);

    void setDescription(String description);

    void setNumber(String number);

    void setType(String type);
}
