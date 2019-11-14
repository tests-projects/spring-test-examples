package me.chanjar.annotation.testconfig.ex3;

import static org.testng.Assert.assertNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = ExcludeConfig1.class)
public class TestConfigExclude_1_Test extends AbstractTestNGSpringContextTests {

    @Autowired(required = false)
    private TestConfig testConfig;

    @Test
    public void test() throws Exception {
        // 过滤了 @TestConfiguration 注释的Bean
        assertNull(testConfig);
    }

}
