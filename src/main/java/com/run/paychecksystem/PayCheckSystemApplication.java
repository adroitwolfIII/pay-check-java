package com.run.paychecksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages={"com.run.paychecksystem.mapper"})
public class PayCheckSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayCheckSystemApplication.class, args);
    }

}
