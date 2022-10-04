package com.myapp.consumerservice01.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.myapp.consumerservice01.service.feign.ProviderServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RefreshScope
@RestController
@Slf4j
public class TestController {
    @Resource
    private ProviderServiceService providerServiceDao;
    // @Value("${info.version}")
    String version;
    // @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/consumer/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        log.debug("send str:"+str);
        return providerServiceDao.echoString(str);
    }
    @RequestMapping(value = "/consumer/v", method = RequestMethod.GET)
    public String version() {
        return "from port"+port+"---"+version;
    }
    @GetMapping(value="/break")
    @SentinelResource(value = "break",blockHandler = "blockHandler",fallback = "fallBackHandler")
    public String circuitBreak() throws InterruptedException {
        // TimeUnit.SECONDS.sleep(8);
        int j = 1/0;
        return "circuit break";
    }
    public String blockHandler(BlockException blockException) {
        log.debug(blockException.getMessage());
        return "request fail";
    }
    public String fallBackHandler() {
        return "encounter exception";
    }
}
