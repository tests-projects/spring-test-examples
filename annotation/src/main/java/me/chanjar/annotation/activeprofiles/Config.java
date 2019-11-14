package me.chanjar.annotation.activeprofiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    /**
     * 指定 profile 为 dev
     * @return name是 dev 的Foo
     */
    @Bean
    @Profile("dev")
    public Foo fooDev() {
        return new Foo("dev");
    }

    /**
     * 指定 profile 为 product
     * @return name是 product 的Foo
     */
    @Bean
    @Profile("product")
    public Foo fooProduct() {
        return new Foo("product");
    }

    /**
     * 默认 profile
     * @return name是default的Foo
     */
    @Bean
    @Profile("default")
    public Foo fooDefault() {
        return new Foo("default");
    }

    /**
     * 没有指定 profile
     * @return name是 no profile 的Bar
     */
    @Bean
    public Bar bar() {
        return new Bar("no profile");
    }

}
