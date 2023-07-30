package com.dlucchesi.yhfin.facade.imp;

import com.dlucchesi.yhfin.model.User;
import com.dlucchesi.yhfin.model.data.LoginData;
import com.dlucchesi.yhfin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service("userFacade")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserFacadeImp implements com.dlucchesi.yhfin.facade.UserFacade {

    protected final UserService userService;

    @Override
    public User doLogin(LoginData login) {
        User ret = null;
        log.debug("User trying login. login {}", login);
        if (!isNull(login)) {
            Optional<User> optU = userService.findByUserId(login.getLogin());
            if (optU.isPresent()){
                User user = optU.get();
                log.debug("User found! User {}", user);
                if (user.getPassword().equals(login.getPassword())) {
                    log.debug("User password match! User {}", user);
                    if (activeUser(user)){
                        ret = user;
                    }
                } else {
                    log.info("User password not match!. Login {}", login);
                }
            } else {
                log.info("User not found. Login {}", login);
            }
        } else {
            log.warn("Receive empty req!");
        }
        return ret;
    }

    private Boolean activeUser(User user) {
        Boolean ret = Boolean.FALSE;
        if (!isNull(user)){
            if(!user.getIsDeleted()) {
                if (user.getIsActive()) {
                    ret = Boolean.TRUE;
                } else {
                    log.info("User is not active. User {}", user);
                }
            } else {
                log.info("User is deleted. User {}", user);
            }
        }
        return ret;
    }
}
