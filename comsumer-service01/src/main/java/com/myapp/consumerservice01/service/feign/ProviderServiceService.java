package com.myapp.consumerservice01.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Component
@FeignClient(value = "service-provider",fallback = ProviderServiceServiceFallBack.class)
public interface ProviderServiceService {
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    String echoString(@PathVariable("str") String str);
    @RequestMapping(value = "/provider01/deductAndCalculate",method = RequestMethod.POST)
    BigDecimal deductAnCalculate(@RequestParam("commodityId") Integer commodityId, @RequestParam("count")Integer count);
}
