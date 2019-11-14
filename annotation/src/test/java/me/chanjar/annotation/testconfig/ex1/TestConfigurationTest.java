package me.chanjar.annotation.testconfig.ex1;

import static org.testng.Assert.assertEquals;

import me.chanjar.annotation.testconfig.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@SpringBootConfiguration
public class TestConfigurationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private Foo foo;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(foo.getName(), "from test config");
    }

    /**
     * [@TestConfiguration]是Spring Boot Test提供的一种工具，只是对既有配置的一个补充.
     * 用它我们可以在一般的@Configuration之外补充测试专门用的Bean或者自定义的配置。
     *
     * [@TestConfiguration]实际上是一种[@TestComponent]，
     * [@TestComponent]是另一种@Component，在语义上用来指定某个Bean是专门用于测试的.
     *
     * [@TestConfiguration]作为内部类的时候它是会被@SpringBootTest扫描掉的，这点和@Configuration一样
     */
    @TestConfiguration
    public class TestConfig {

        @Bean
        public Foo foo() {
            return new Foo("from test config");
        }
    }
}
