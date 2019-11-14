package me.chanjar.annotation.testconfig.ex3;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用@SpringBootApplication来排除`TestConfig
 *
 * [@SpringBootApplication]已经添加了
 * @ComponentScan(excludeFilters = {
 * 		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 * 		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 */
@SpringBootApplication
public interface ExcludeConfig2 {
}
