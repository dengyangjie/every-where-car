package com.information.push.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author dengyangjie
 * @version v1.0
 * @Date 2020-6-9下午 04:36
 * @Description
 */
@SpringBootApplication(scanBasePackages = {"com.information.push.common","com.information.push.dao.mapper","com.information.push.web","com.information.push.*"})
@MapperScan("com.information.center.dao.mapper")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    /**
     * 使用外部tomcat
     * */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    /**
     * 设置项目编码
     * */
    @Bean
    public CharacterEncodingFilter characterEncodingFilter(){
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}
