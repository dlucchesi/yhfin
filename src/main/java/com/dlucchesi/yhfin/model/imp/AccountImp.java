package com.dlucchesi.yhfin.model.imp;

import com.dlucchesi.yhfin.model.AccEntry;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "t_account")
@SequenceGenerator(name="un_seq", sequenceName="t_acc_seq", allocationSize=1)
public class AccountImp extends BasicEntityImp implements com.dlucchesi.yhfin.model.Account {

    protected String label;
    protected String description;
    protected String number;
    protected String type;
    @OneToMany(mappedBy = "account", targetEntity = AccEntryImp.class)
    protected Set<AccEntry> entries;

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
