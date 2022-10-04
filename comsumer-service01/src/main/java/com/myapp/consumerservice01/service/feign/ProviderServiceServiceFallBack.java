package com.myapp.consumerservice01.service.feign;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProviderServiceServiceFallBack implements ProviderServiceService {
    @Override
    public String echoString(String str){
        return "down ---"+str;
    }

    @Override
    public BigDecimal deductAnCalculate(Integer commodityId, Integer count) {
        return null;
    }
}
