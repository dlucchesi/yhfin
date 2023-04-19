package com.dlucchesi.yhfin.model.imp;

import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_user_access_account")
@SequenceGenerator(name="un_seq", sequenceName="t_useraccessacc_seq", allocationSize=1)
public class UserAccessAccountImp extends BasicEntityImp implements com.dlucchesi.yhfin.model.UserAccessAccount {

    @ManyToOne(targetEntity = UserImp.class)
    @JoinColumn(name = "user_id")
    protected User user;
    @ManyToOne(targetEntity = AccountImp.class)
    @JoinColumn(name = "account_id")
    protected Account account;

    protected Boolean isOwner;
    protected Date insertDate;

    @Override
    public String toString() {
        return "UserAccessAccountImp{" +
                "user=" + user.getId() +
                ", account=" + account.getId() +
                ", isOwner=" + isOwner +
                ", insertDate=" + insertDate +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", isActive=" + isActive +
                '}';
    }
}
