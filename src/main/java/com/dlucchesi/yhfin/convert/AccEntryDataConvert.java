package com.dlucchesi.yhfin.convert;

import com.dlucchesi.yhfin.model.AccEntry;
import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.EntryType;
import com.dlucchesi.yhfin.model.data.AccEntryData;
import com.dlucchesi.yhfin.service.AccEntryService;
import com.dlucchesi.yhfin.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AccEntryDataConvert extends BasicEntityDataConvert<AccEntry, AccEntryData>{

    final AccEntryService accEntryService;
    final AccountService accountService;

    @Override
    public AccEntryData convertToData(AccEntry imp) {
        AccEntryData ret = new AccEntryData();
        ret.setAccountId(imp.getAccount().getId());
        ret.setType(imp.getType().name());
        ret.setAmount(imp.getAmount());
        ret.setLabel(imp.getLabel());
        ret.setDescription(imp.getDescription());
        ret.setId(imp.getId());
        ret.setIsActive(imp.getIsActive());
        ret.setIsDeleted(imp.getIsDeleted());
        ret.setEntryDate(imp.getEntryDate());

        return ret;
    }

    @Override
    public AccEntry convertToImp(AccEntryData data) {
        AccEntry ret = accEntryService.create();
        Optional<Account> opt = accountService.find(data.getAccountId());
        if (opt.isPresent()){
            ret.setAccount(opt.get());
        }
        else{
            log.error("Account not found for id: {}", data.getAccountId());
            throw new RuntimeException("Account not found for id: " + data.getAccountId());
        }
        ret.setType(EntryType.valueOf(data.getType()));
        ret.setAmount(data.getAmount());
        ret.setLabel(data.getLabel());
        ret.setDescription(data.getDescription());
        ret.setId(data.getId());
        ret.setIsActive(data.getIsActive());
        ret.setIsDeleted(data.getIsDeleted());
        ret.setEntryDate(data.getEntryDate());

        return ret;
    }
}
