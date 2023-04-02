package com.dlucchesi.yhfin.model.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class LoginData {

    protected String username;
    protected String password;

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
