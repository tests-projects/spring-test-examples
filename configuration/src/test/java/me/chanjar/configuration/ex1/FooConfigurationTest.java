package me.chanjar.configuration.ex1;

import static org.testng.Assert.assertNotNull;

import me.chanjar.configuration.service.Foo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @BeforeMethod
    public void init() {
        // 首先，构造一个Contex
        context = new AnnotationConfigApplicationContext();
    }

    @AfterMethod(alwaysRun = true)
    public void reset() {
        // 最后，在测试方法结尾close Context
        context.close();
    }

    @Test
    public void testFooCreation() {
        // 然后，注册FooConfiguration
        context.register(FooConfiguration.class);
        // 然后，refresh Context
        context.refresh();
        assertNotNull(context.getBean(Foo.class));
    }

}
