package com.myapp.consumerservice01;

import com.myapp.consumerservice01.conf.LbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@LoadBalancerClients(defaultConfiguration = {LbConfig.class})
public class ConsumerService01Application {


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConsumerService01Application.class, args);
        // while (true){
        //     String version = applicationContext.getEnvironment().getProperty("info.version");
        //     System.err.println("version :" +version);
        //     TimeUnit.SECONDS.sleep(1);
        // }
    }


}
