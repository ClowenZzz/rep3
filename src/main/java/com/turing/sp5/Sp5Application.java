package com.turing.sp5;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.turing..sp5.mapper")
public class Sp5Application {

    public static void main(String[] args) {
        SpringApplication.run(Sp5Application.class, args);
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

}
