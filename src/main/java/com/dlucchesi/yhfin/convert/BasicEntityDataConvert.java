package com.dlucchesi.yhfin.convert;

import com.dlucchesi.yhfin.model.BasicEntity;
import com.dlucchesi.yhfin.model.data.BasicEntityData;

public abstract class BasicEntityDataConvert<I extends BasicEntity, E extends BasicEntityData> {

    public abstract E convertToData(I imp);

    public abstract I convertToImp(E data);
}
