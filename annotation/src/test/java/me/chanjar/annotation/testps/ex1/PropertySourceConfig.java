package me.chanjar.annotation.testps.ex1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * [@PropertySource]从me/chanjar/annotation/testps/ex1/property-source.properties中加载属性
 */
@Configuration
@PropertySource("classpath:me/chanjar/annotation/testps/ex1/property-source.properties")
public class PropertySourceConfig {
}
