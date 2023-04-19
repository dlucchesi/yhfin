package com.dlucchesi.yhfin.service.imp;

import com.dlucchesi.yhfin.model.BasicEntity;
import com.dlucchesi.yhfin.model.User;
import com.dlucchesi.yhfin.model.imp.BasicEntityImp;
import com.dlucchesi.yhfin.model.imp.UserImp;
import com.dlucchesi.yhfin.util.BasicEntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public abstract class BasicServiceImp<E extends BasicEntity
            , I extends BasicEntityImp
            , R extends JpaRepository<E,Long>> {

    final R impRepository;

//    public E create(){
//        E i = newIns;
//        return i;
//    }

//    public Set<E> find;

//    public Optional<E> find(Long id){
//        Optional<E> ret = Optional.empty();
//        Optional<I> opt = impRepository.findById(id);
//        if (opt.isPresent()){
//            I tmp = opt.get();
//            E entity = tmp;
//            ret = Optional.of(entity);
//        }
//        return ret;
//    }
//
//    public Optional<User> findByUserId(String userId){
//        Optional<User> ret = Optional.empty();
//        UserImp opt = impRepository.findByUserId(userId);
//        if (isNull(opt)){
//            ret = Optional.ofNullable(opt);
//        }
//        return ret;
//    }
//
//    public Optional<User> save(User instance){
//        Optional<User> ret = Optional.empty();
//        if (!isNull(instance)){
//            UserImp userImp = validateInstance(instance);
//            if (!isNull(userImp)){
//                if (validateObj(userImp)){
//                    ret = Optional.of(impRepository.save(userImp));
//                }
//            } else {
//                log.error("Instance error! Instance: {}", instance);
//            }
//        } else {
//            log.warn("User empty!");
//        }
//        return ret;
//    }
//
//    public Boolean delete(User entity, Boolean phys){
//        Boolean ret = Boolean.TRUE;
//        Boolean bPhys = Boolean.FALSE;
//        if (!isNull(entity)){
//            Optional<UserImp> opt = impRepository.findById(entity.getId());
//            if (opt.isPresent()) {
//                if (!isNull(phys)){
//                    bPhys = phys;
//                } else {
//                    log.warn("Boolean to physical delete is empty! Assuming FALSE");
//                }
//                UserImp userImp = opt.get();
//                if (!bPhys){
//                    BasicEntityUtil.makeDeleted(userImp);
//                    impRepository.save(userImp);
//                } else {
//                    log.warn("** ATTENTION: Deleting physically! User: {}", entity);
//                    impRepository.delete(userImp);
//                }
//            } else {
//                log.error("User to delete, not found");
//            }
//        } else {
//            log.warn("User empty!");
//            ret = Boolean.FALSE;
//        }
//        return ret;
//    }
//
//    private UserImp validateInstance(User instance) {
//        if (!isNull(instance) && instance instanceof UserImp){
//            return (UserImp) instance;
//        }
//        return null;
//    }
//
//    private Boolean validateObj(UserImp imp) {
//        Boolean ret = Boolean.TRUE;
//        if (!isNull(imp)){
//            String userId = imp.getUserId();
//            if (isNull(userId) || userId.trim().length() == 0){
//                log.warn("User validation error! UserId empty. User: {}", imp);
//                ret = Boolean.FALSE;
//            } else {
//                String passwd = imp.getPassword();
//                if (isNull(passwd) || passwd.trim().length() == 0){
//                    log.warn("User validation error! Password empty. User: {}", imp);
//                    ret = Boolean.FALSE;
//                }
//            }
//        }
//        return ret;
//    }
}
