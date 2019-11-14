package me.chanjar.spring1;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import me.chanjar.common.Bar;
import me.chanjar.common.Foo;
import me.chanjar.common.FooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 启用Spring和Mockito，必须添加：
 * @TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
 */
@ContextConfiguration(classes = FooImpl.class)
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class Spring_1_Test extends AbstractTestNGSpringContextTests {

    @MockBean
    private Bar bar;

    @Autowired
    private Foo foo;

    @Test
    public void testCheckCodeDuplicate() throws Exception {
        when(bar.getAllCodes()).thenReturn(Collections.singleton("123"));
        assertEquals(foo.checkCodeDuplicate("123"), true);
    }

}
