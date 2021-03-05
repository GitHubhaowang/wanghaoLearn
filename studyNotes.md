**注解**
- @EnableAutoConfiguration
开启自动配置，会根据pom.xml文件中依赖自动判断 例如spring-boot-starter-web搭建web项目
- @Component
扫描相关注解
范围：当前包及子包
- @RestController
@Controller（实例一个控制器） + @ResponseBody(返回值转换为json返回给浏览器)
