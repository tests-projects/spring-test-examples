package me.chanjar.basic.spring.ex3;

import me.chanjar.basic.service.FooServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 将@Configuration放到外部，测试类中让[@ContextConfiguration]去加载。
 *
 * 需要注意的是，如果`@Configuration`是专供某个测试类使用的话，
 * 把它放到外部并不是一个好主意，因为它有可能会被`@ComponentScan`扫描到，从而产生一些奇怪的问题
 */
@Configuration
@Import(FooServiceImpl.class)
public class Config {
}
