package com.hh;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/4
 */
@EnableAutoConfiguration    // 开启自动配置
@ComponentScan  // 扫描注解 范围：当前入口类所在包及子包
public class Application {
    public static void main(String[] args) {
        // 启动springboot应用
        // 参数1：入口类class对象   参数2：main函数参数
        SpringApplication.run(Application.class, args);
    }
}
