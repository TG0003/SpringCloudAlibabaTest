package com.myapp.providerservice02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderService02Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderService02Application.class, args);
        String version = applicationContext.getEnvironment().getProperty("info.version");
        System.err.println("version :" +version);
    }
}
