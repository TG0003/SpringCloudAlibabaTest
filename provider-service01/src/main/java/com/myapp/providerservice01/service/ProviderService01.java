package com.myapp.providerservice01.service;

import com.myapp.providerservice01.entity.Storage;

import java.math.BigDecimal;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
public interface ProviderService01 {
    BigDecimal deduct (Integer commodityId, Integer count) throws Exception;
}
