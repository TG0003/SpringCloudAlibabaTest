package com.myapp.consumerservice01.controller;

import com.myapp.consumerservice01.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@RestController
@Slf4j
public class SeataTestController {
    @Resource
    private ConsumerService consumerService;
    @PostMapping("/seata/purchase")
    public String purchase(@RequestParam("uid") Integer uid, @RequestParam("commodityId") Integer commodityId, @RequestParam("purchaseNum") Integer purchaseNum){
        return consumerService.purchase(uid,commodityId,purchaseNum);
    }
}
