package me.chanjar.annotation.testconfig.ex3;

import static org.testng.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = IncludeConfig.class)
public class TestConfigIncludedTest extends AbstractTestNGSpringContextTests {

    @Autowired(required = false)
    private TestConfig testConfig;

    @Test
    public void testPlusCount() throws Exception {
        // @TestConfiguration 注释的Bean 被加载了
        assertNotNull(testConfig);
    }

}
