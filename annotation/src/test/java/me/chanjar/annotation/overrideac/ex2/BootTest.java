package me.chanjar.annotation.overrideac.ex2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 使用 @OverrideAutoConfiguration(enabled = false) 关闭AutoConfiguration
 */
@SpringBootTest
@SpringBootApplication
@OverrideAutoConfiguration(enabled = false)
public class BootTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testName() throws Exception {

    }
}
