package me.chanjar.annotation.testconfig.ex3;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 没有做任何过滤(@TestConfiguration)的情形
 */
@ComponentScan
@SpringBootConfiguration
public interface IncludeConfig {
}
