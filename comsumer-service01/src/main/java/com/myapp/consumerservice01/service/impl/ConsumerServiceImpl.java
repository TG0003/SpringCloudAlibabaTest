package com.myapp.consumerservice01.service.impl;

import com.myapp.consumerservice01.dao.UserDao;
import com.myapp.consumerservice01.entity.User;
import com.myapp.consumerservice01.service.ConsumerService;
import com.myapp.consumerservice01.service.feign.ProviderServiceService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {
    @Resource
    private UserDao userDao;
    @Resource
    private ProviderServiceService providerServiceService;
    @Override
    @Transactional
    @GlobalTransactional
    public String purchase(Integer uid, Integer commodityId,Integer count) {
        log.debug("xid:"+ RootContext.getXID());
        User user = userDao.findUserById(uid);
        if (Objects.isNull(user)){
            return "user not exist";
        }
        log.debug(user.toString());
        BigDecimal totalPrice = providerServiceService.deductAnCalculate(commodityId,count);
        log.debug("totalPrice:"+totalPrice);
        // decrease user balance
        userDao.deductBalance(uid,totalPrice);
        if (count > 2){
            throw new RuntimeException("occur exception");
        }
        return "ok";
    }
}
