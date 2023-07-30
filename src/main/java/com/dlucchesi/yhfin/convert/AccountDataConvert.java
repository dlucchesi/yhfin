package com.dlucchesi.yhfin.convert;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.BasicEntity;
import com.dlucchesi.yhfin.model.data.AccountData;
import com.dlucchesi.yhfin.service.AccEntryService;
import com.dlucchesi.yhfin.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AccountDataConvert extends BasicEntityDataConvert<Account, AccountData>{

    final AccEntryService accEntryService;
    final AccountService accountService;
    @Override
    public AccountData convertToData(Account imp) {
        AccountData ret = new AccountData();
        ret.setLabel(imp.getLabel());
        ret.setDescription(imp.getDescription());
        ret.setNumber(imp.getNumber());
        ret.setType(imp.getType());
        ret.setId(imp.getId());
        ret.setIsActive(imp.getIsActive());
        ret.setIsDeleted(imp.getIsDeleted());
        HashSet<Long> entries = accEntryService.findByAccount(imp).stream()
                .map(BasicEntity::getId)
                .collect(Collectors.toCollection(HashSet::new));
        ret.setEntries(entries);
        return ret;
    }

    @Override
    public Account convertToImp(AccountData data) {
        Account ret = accountService.create();
        ret.setLabel(data.getLabel());
        ret.setDescription(data.getDescription());
        ret.setNumber(data.getNumber());
        ret.setType(data.getType());
        ret.setId(data.getId());
        ret.setIsActive(data.getIsActive());
        ret.setIsDeleted(data.getIsDeleted());

        return ret;
    }
}
