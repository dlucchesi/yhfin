package com.dlucchesi.yhfin.facade.imp;

import com.dlucchesi.yhfin.exceptions.LoginDeletedUserException;
import com.dlucchesi.yhfin.exceptions.LoginInactiveUserException;
import com.dlucchesi.yhfin.exceptions.LoginNotFoundException;
import com.dlucchesi.yhfin.exceptions.LoginWrongPasswordException;
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
    public User doLogin(LoginData login) throws LoginWrongPasswordException,
            LoginNotFoundException, LoginInactiveUserException, LoginDeletedUserException {
        log.debug("User trying login. login {}", login);
        if (!isNull(login)) {
            Optional<User> optU = userService.findByUserId(login.getLogin());
            if (optU.isPresent()){
                User user = optU.get();
                log.debug("User found! User {}", user);
                if (user.getPassword().equals(login.getPassword())) {
                    log.debug("User password match! User {}", user);
                    if (activeUser(user)){
                        return user;
                    }
                } else {
                    log.info("User password not match!. Login {}", login);
                    throw new LoginWrongPasswordException("Wrong password");
                }
            } else {
                log.info("User not found. Login {}", login);
                throw new LoginNotFoundException("User not found");
            }
        } else {
            log.warn("Receive empty req!");
        }
        return null;
    }

    private Boolean activeUser(User user) throws LoginDeletedUserException, LoginInactiveUserException {
        Boolean ret = Boolean.FALSE;
        if (!isNull(user)){
            if(!user.getIsDeleted()) {
                if (user.getIsActive()) {
                    ret = Boolean.TRUE;
                } else {
                    throw new LoginInactiveUserException("Inactive user! User " + user);
                }
            } else {
                throw new LoginDeletedUserException("Deleted user");
            }
        }
        return ret;
    }
}
