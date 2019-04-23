package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @ClassName: SpitApplicaiton
 * @Author: lish
 * @Date: 2019/4/23 11:15
 * @Description: ${description}
 */

@SpringBootApplication
public class SpitApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(SpitApplicaiton.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
