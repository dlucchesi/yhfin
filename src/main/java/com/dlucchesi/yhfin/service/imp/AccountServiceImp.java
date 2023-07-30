package com.dlucchesi.yhfin.service.imp;

import com.dlucchesi.yhfin.model.Account;
import com.dlucchesi.yhfin.model.imp.AccountImp;
import com.dlucchesi.yhfin.repository.AccountImpRepository;
import com.dlucchesi.yhfin.util.BasicEntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service("accountService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AccountServiceImp implements com.dlucchesi.yhfin.service.AccountService {

    final AccountImpRepository accountImpRepository;
    @Override
    public Account create(){
        return new AccountImp();
    }
     @Override
     public Set<Account> find(){
        return accountImpRepository.findAll().stream()
                .map(Account.class::cast)
                .collect(Collectors.toSet());
    }
    @Override
    public Optional<Account> find(Long id){
        Optional<Account> ret = Optional.empty();
        Optional<AccountImp> opt = accountImpRepository.findById(id);
        if (opt.isPresent()){
            AccountImp tmp = opt.get();
            ret = Optional.of(tmp);
        }
        return ret;
    }
    @Override
    public Optional<Account> save(Account instance){
        Optional<Account> ret = Optional.empty();
        if (!isNull(instance)){
            AccountImp accImp = validateInstance(instance);
            if (!isNull(accImp)){
                if (validateObj(accImp)){
                    ret = Optional.of(accountImpRepository.save(accImp));
                }
            } else {
                log.error("Instance error! Instance: {}", instance);
            }
        } else {
            log.warn("Account empty!");
        }
        return ret;
    }
    @Override
    public Boolean delete(Account entity, Boolean phys){
        Boolean ret = Boolean.TRUE;
        Boolean bPhys = Boolean.FALSE;
        if (!isNull(entity)){
            Optional<AccountImp> opt = accountImpRepository.findById(entity.getId());
            if (opt.isPresent()) {
                if (!isNull(phys)){
                    bPhys = phys;
                } else {
                    log.warn("Boolean to physical delete is empty! Assuming FALSE");
                }
                AccountImp accImp = opt.get();
                if (!bPhys){
                    BasicEntityUtil.makeDeleted(accImp);
                    accountImpRepository.save(accImp);
                } else {
                    log.warn("** ATTENTION: Deleting physically! Acc: {}", entity);
                    accountImpRepository.delete(accImp);
                }
            } else {
                log.error("Account to delete, not found");
            }
        } else {
            log.warn("Account empty!");
            ret = Boolean.FALSE;
        }
        return ret;
    }

    private AccountImp validateInstance(Account instance) {
        if (!isNull(instance) && instance instanceof AccountImp){
            return (AccountImp) instance;
        }
        return null;
    }

    private Boolean validateObj(AccountImp imp) {
        Boolean ret = Boolean.TRUE;
        if (!isNull(imp)){
            String label = imp.getLabel();
            if (isNull(label) || label.trim().length() == 0){
                log.warn("Account validation error! Label empty. Acc: {}", imp);
                ret = Boolean.FALSE;
            } else {
                String number = imp.getNumber();
                if (isNull(number) || number.trim().length() == 0){
                    log.warn("Account validation error! Number empty. Acc: {}", imp);
                    ret = Boolean.FALSE;
                }
            }
        }
        return ret;
    }
}
