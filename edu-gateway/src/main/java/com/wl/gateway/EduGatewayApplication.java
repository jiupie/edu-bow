package com.wl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EduGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduGatewayApplication.class, args);
    }
}
