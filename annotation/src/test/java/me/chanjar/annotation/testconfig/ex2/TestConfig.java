package me.chanjar.annotation.testconfig.ex2;

import me.chanjar.annotation.testconfig.Foo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    /**
     * [@TestConfiguration] 覆盖已存在的Bean
     * @return Foo
     */
    // 这里不需要@Primary之类的机制，直接就能够覆盖
    @Bean
    public Foo foo() {
        return new Foo("from test config");
    }

    /**
     * [@TestConfiguration] 补充额外的Bean
     * @return Foo
     */
    @Bean
    public Foo foo2() {
        return new Foo("from test config2");
    }
}
