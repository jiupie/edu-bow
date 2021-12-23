package com.wl;

import com.wl.core.encrypt.annotation.EnableEncrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEncrypt
@EnableFeignClients
public class EduTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduTestApplication.class, args);
    }
}
