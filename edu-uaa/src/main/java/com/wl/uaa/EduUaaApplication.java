package com.wl.uaa;

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
@EnableFeignClients
public class EduUaaApplication {

        public static void main(String[] args) {
            SpringApplication.run(EduUaaApplication.class, args);
        }

}
