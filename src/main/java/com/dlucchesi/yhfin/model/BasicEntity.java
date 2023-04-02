package com.dlucchesi.yhfin.model;

import java.io.Serializable;

public interface BasicEntity extends Serializable {
    boolean canEqual(Object obj);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();

    Long getId();

    Boolean getIsDeleted();

    Boolean getIsActive();

    void setId(Long id);

    void setIsDeleted(Boolean isDeleted);

    void setIsActive(Boolean isActive);
}
