package com.dlucchesi.yhfin.util;

import com.dlucchesi.yhfin.model.BasicEntity;

import static java.util.Objects.isNull;

public class BasicEntityUtil {

    public static Boolean isNew(BasicEntity entity){
        return isNull(entity.getId());
    }

    public static void makeNew(BasicEntity entity){
        if (!isNull(entity)){
            entity.setIsActive(Boolean.TRUE);
            entity.setIsDeleted(Boolean.FALSE);
        }
    }

    public static void makeDeleted(BasicEntity entity){
        if (!isNull(entity)){
            entity.setIsActive(Boolean.FALSE);
            entity.setIsDeleted(Boolean.TRUE);
        }
    }

    public static void makeInactive(BasicEntity entity){
        if (!isNull(entity)){
            entity.setIsActive(Boolean.FALSE);
        }
    }

}
