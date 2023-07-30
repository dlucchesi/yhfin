package com.dlucchesi.yhfin.model.imp;

import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.EntryType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_acc_entry")
@SequenceGenerator(name="un_seq", sequenceName="t_accentry_seq", allocationSize=1)
public class AccEntryImp extends BasicEntityImp implements com.dlucchesi.yhfin.model.AccEntry {

    protected String label;
    protected String description;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    protected Date entryDate;
    protected Double amount;
    @Enumerated(EnumType.STRING)
    protected EntryType type;
    @JsonIgnore
    protected Account account;

    @Override
    public String toString() {
        return "AccEntryImp{" +
                "label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", entryDate=" + entryDate +
                ", amount=" + amount +
                ", type=" + type +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", isActive=" + isActive +
                '}';
    }
}
