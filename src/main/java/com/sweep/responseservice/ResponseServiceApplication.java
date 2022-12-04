package com.sweep.responseservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@EnableMongoRepositories(basePackages = "com.sweep.responseservice.domain")
@Slf4j
public class ResponseServiceApplication {

    @PostConstruct
    public void started() {
        log.info("Server On : " + new Date());
    }
    public static void main(String[] args) {
        SpringApplication.run(ResponseServiceApplication.class, args);
    }

}
