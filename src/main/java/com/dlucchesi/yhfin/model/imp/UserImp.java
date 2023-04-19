package com.dlucchesi.yhfin.model.imp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_user")
@SequenceGenerator(name="un_seq", sequenceName="t_user_seq", allocationSize=1)
public class UserImp extends BasicEntityImp implements com.dlucchesi.yhfin.model.User {

    @Column(name = "user_id", nullable = false, unique = true)
    protected String userId;
    protected String password;



    @Override
    public String toString() {
        return "UserImp{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", isActive=" + isActive +
                '}';
    }
}
