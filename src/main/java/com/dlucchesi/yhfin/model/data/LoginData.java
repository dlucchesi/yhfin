package com.dlucchesi.yhfin.model.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
public class LoginData implements Serializable {

    protected String login;
    protected String password;

    @Override
    public String toString() {
        return "LoginData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
