package com.hh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/5
 */
@EnableAutoConfiguration    // 作用：开启自动配置，会根据pom.xml文件中依赖自动判断 例如spring-boot-starter-web搭建web项目
@Component  // 作用：扫描相关注解 扫描范围：当前包及子包
public class Application {
    public static void main(String[] args) {
        // 作用：用来启动springboot应用
        // 参数1：当前类类对象 参数2：main函数参数
        SpringApplication.run(Application.class, args);
    }
}
