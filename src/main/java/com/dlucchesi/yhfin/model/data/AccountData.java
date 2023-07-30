package com.dlucchesi.yhfin.model.data;

import com.dlucchesi.yhfin.model.AccEntry;
import com.dlucchesi.yhfin.model.imp.AccEntryImp;
import com.dlucchesi.yhfin.model.imp.BasicEntityImp;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AccountData extends BasicEntityData {

    protected String label;
    protected String description;
    protected String number;
    protected String type;  //Checking account, savings account, credit card, etc.
    protected Set<Long> entries;

    @Override
    public String toString() {
        return "AccountImp{" +
                "label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", isActive=" + isActive +
                '}';
    }
}
