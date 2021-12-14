package com.wl.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DocGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocGatewayApplication.class, args);
    }
}
