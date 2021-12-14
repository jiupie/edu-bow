package com.wl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableOpenApi
@MapperScan(basePackages = "com.wl.ad.dao")
public class EduAdApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduAdApplication.class, args);
    }
}
