package com.wl.springboot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class EduAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduAdminServerApplication.class,args);
    }
}
