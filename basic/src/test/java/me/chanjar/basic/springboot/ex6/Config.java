package me.chanjar.basic.springboot.ex6;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用`@SpringBootApplication`，它有这么几个好处：
 * 1. 自身`SpringBootConfiguration`
 * 2. 提供了`@ComponentScan`配置，以及默认的excludeFilter，
 *    有了这些filter Spring在初始化ApplicationContext的时候会排除掉某些Bean和@Configuration
 * 3. 启用了`EnableAutoConfiguration`，这个特性能够利用Spring Boot来自动化配置所需要的外部资源，
 *    比如数据库、JMS什么的，这在集成测试的时候非常有用。
 */
@SpringBootApplication(scanBasePackages = "me.chanjar.basic.service")
public class Config {
}
