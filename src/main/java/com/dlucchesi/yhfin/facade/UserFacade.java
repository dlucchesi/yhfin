package com.dlucchesi.yhfin.facade;

import com.dlucchesi.yhfin.model.User;
import com.dlucchesi.yhfin.model.data.LoginData;

public interface UserFacade {
    User doLogin(LoginData login);
}
