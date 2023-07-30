package com.dlucchesi.yhfin.service.imp;

import com.dlucchesi.yhfin.model.AccEntry;
import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.imp.AccEntryImp;
import com.dlucchesi.yhfin.repository.AccEntryImpRepository;
import com.dlucchesi.yhfin.util.BasicEntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service("accEntryService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AccEntryServiceImp implements com.dlucchesi.yhfin.service.AccEntryService {

    final AccEntryImpRepository accEntryImpRepository;
    @Override
    public AccEntry create(){
        return new AccEntryImp();
    }
    @Override
    public Set<AccEntry> find(){
        return accEntryImpRepository.findAll().stream()
            .map(AccEntry.class::cast)
            .collect(Collectors.toSet());
    }
    @Override
    public Optional<AccEntry> find(Long id){
        Optional<AccEntry> ret = Optional.empty();
        Optional<AccEntryImp> opt = accEntryImpRepository.findById(id);
        if (opt.isPresent()){
            AccEntryImp tmp = opt.get();
            ret = Optional.of(tmp);
        }
        return ret;
    }
    @Override
    public Set<AccEntry> findByAccount(Account account){
        Set<AccEntry> ret = new HashSet<>();
        Set<AccEntryImp> lst = accEntryImpRepository.findByAccount(account);
        if (!isNull(lst) && !lst.isEmpty()){
            ret = lst.stream()
                .map(AccEntry.class::cast)
                .collect(Collectors.toSet());
        }
        return ret;
    }
    @Override
    public Optional<AccEntry> save(AccEntry instance){
        Optional<AccEntry> ret = Optional.empty();
        if (!isNull(instance)){
            AccEntryImp accImp = validateInstance(instance);
            if (!isNull(accImp)){
                if (validateObj(accImp)){
                    ret = Optional.of(accEntryImpRepository.save(accImp));
                }
            } else {
                log.error("Instance error! Instance: {}", instance);
            }
        } else {
            log.warn("AccEntry empty!");
        }
        return ret;
    }
    @Override
    public Boolean delete(AccEntry entity, Boolean phys){
        Boolean ret = Boolean.TRUE;
        Boolean bPhys = Boolean.FALSE;
        if (!isNull(entity)){
            Optional<AccEntryImp> opt = accEntryImpRepository.findById(entity.getId());
            if (opt.isPresent()) {
                if (!isNull(phys)){
                    bPhys = phys;
                } else {
                    log.warn("Boolean to physical delete is empty! Assuming FALSE");
                }
                AccEntryImp accImp = opt.get();
                if (!bPhys){
                    BasicEntityUtil.makeDeleted(accImp);
                    accEntryImpRepository.save(accImp);
                } else {
                    log.warn("** ATTENTION: Deleting physically! Acc: {}", entity);
                    accEntryImpRepository.delete(accImp);
                }
            } else {
                log.error("AccEntry to delete, not found");
            }
        } else {
            log.warn("AccEntry empty!");
            ret = Boolean.FALSE;
        }
        return ret;
    }
    private AccEntryImp validateInstance(AccEntry instance) {
        if (!isNull(instance) && instance instanceof AccEntryImp){
            return (AccEntryImp) instance;
        }
        return null;
    }

    private Boolean validateObj(AccEntryImp imp) {
        Boolean ret = Boolean.TRUE;
        if (!isNull(imp)){
            String label = imp.getLabel();
            if (isNull(label) || label.trim().length() == 0){
                log.error("AccEntry validation error! Label empty. Entry: {}", imp);
                ret = Boolean.FALSE;
            } else {
                Date date = imp.getEntryDate();
                if (isNull(date)){
                    log.error("AccEntry validation error! EntryDate empty. Entry: {}", imp);
                    ret = Boolean.FALSE;
                } else {
                    Double amount = imp.getAmount();
                    if (isNull(amount) || amount.equals(0D)){
                        log.error("AccEntry validation error! Invalid amount. Entry: {}", imp);
                        ret = Boolean.FALSE;
                    } else {
                        Account acc = imp.getAccount();
                        if (isNull(acc)){
                            log.error("AccEntry validation error! Account empty. Entry: {}", imp);
                            ret = Boolean.FALSE;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
