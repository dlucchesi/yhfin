package com.dlucchesi.yhfin.facade;

import com.dlucchesi.yhfin.exceptions.LoginDeletedUserException;
import com.dlucchesi.yhfin.exceptions.LoginInactiveUserException;
import com.dlucchesi.yhfin.exceptions.LoginNotFoundException;
import com.dlucchesi.yhfin.exceptions.LoginWrongPasswordException;
import com.dlucchesi.yhfin.model.User;
import com.dlucchesi.yhfin.model.data.LoginData;

public interface UserFacade {
    User doLogin(LoginData login) throws LoginWrongPasswordException,
            LoginNotFoundException, LoginInactiveUserException, LoginDeletedUserException;
}
