package me.chanjar.annotation.testconfig.ex2;

import static org.testng.Assert.assertEquals;

import me.chanjar.annotation.testconfig.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = {Config.class, TestConfig.class})
public class TestConfigurationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("foo")
    private Foo foo;

    @Autowired
    @Qualifier("foo2")
    private Foo foo2;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(foo.getName(), "from test config");
        assertEquals(foo2.getName(), "from test config2");
    }

}
