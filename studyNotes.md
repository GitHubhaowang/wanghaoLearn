**注解**
- @EnableAutoConfiguration
开启自动配置，会根据pom.xml文件中依赖自动判断 例如spring-boot-starter-web搭建web项目
- @Component
扫描相关注解
范围：当前包及子包
- @RestController
@Controller（实例一个控制器） + @ResponseBody(返回值转换为json返回给浏览器)
- @SpringBootApplication
组合注解
@SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
- @ImportResource
导入 .xml 配置文件
- @RequestMapping
加入访问路径
范围：类、方法
@GetMapping/@PostMapping/@DeleteMapping/@PutMapping
- @Configuration [推荐]
配置注解 类似@Component
- @Bean
交给spring管理一个对象 类似于xml中<bean class=""/>
需在@Configuration定义的类中使用
- @import
类似@Configuration 但只能导入单个类