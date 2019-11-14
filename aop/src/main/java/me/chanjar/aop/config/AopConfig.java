package me.chanjar.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("me.chanjar.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

}
