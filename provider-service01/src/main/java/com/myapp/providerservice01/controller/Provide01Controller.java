package com.myapp.providerservice01.controller;

import com.myapp.providerservice01.service.ProviderService01;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@RestController
public class Provide01Controller {
    @Resource
    private ProviderService01 providerService01;
    @PostMapping("/provider01/deductAndCalculate")
    public BigDecimal deductAndCalculateTotalPrice(Integer commodityId,Integer count) throws Exception{
        return providerService01.deduct(commodityId,count);
    }
}
