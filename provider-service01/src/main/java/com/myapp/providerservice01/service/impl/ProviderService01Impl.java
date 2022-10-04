package com.myapp.providerservice01.service.impl;

import com.myapp.providerservice01.dao.StorageDao;
import com.myapp.providerservice01.entity.Storage;
import com.myapp.providerservice01.exception.BusinessException;
import com.myapp.providerservice01.service.ProviderService01;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@Service
@Slf4j
public class ProviderService01Impl implements ProviderService01 {

    @Resource
    private StorageDao storageDao;
    @Override
    @Transactional
    public BigDecimal deduct (Integer commodityId, Integer count) throws Exception{
        // the storage info
        log.info("xid:"+ RootContext.getXID());
        Storage storage = storageDao.findStorageById(commodityId);
        if (storage.getCount().compareTo(count) < 0){
            throw new BusinessException("sorry!storage not enough");
        }
        // deduct
        storageDao.deductStorage(commodityId,count);
        return storage.getPrice().multiply(new BigDecimal(count));
    }
}
