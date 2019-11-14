package me.chanjar.annotation.activeprofiles.ex1;

import static org.testng.Assert.assertEquals;

import me.chanjar.annotation.activeprofiles.Bar;
import me.chanjar.annotation.activeprofiles.Config;
import me.chanjar.annotation.activeprofiles.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 在没有[@ActiveProfiles]的时候，profile=default和没有设定profile的Bean会被加载到
 */
@ContextConfiguration(classes = Config.class)
public class ActiveProfileTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private Foo foo;

    @Autowired
    private Bar bar;

    @Test
    public void test() {
        assertEquals(foo.getName(), "default");
        assertEquals(bar.getName(), "no profile");
    }

}
