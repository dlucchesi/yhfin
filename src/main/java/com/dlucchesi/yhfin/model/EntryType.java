package com.dlucchesi.yhfin.model;

public enum EntryType {
    DEBIT("DEBIT"),
    CREDIT("CREDIT")
    ;

    public final String name;

    private EntryType(String name) {
        this.name = name;
    }
}
