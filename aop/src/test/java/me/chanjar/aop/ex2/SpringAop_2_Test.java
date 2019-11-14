package me.chanjar.aop.ex2;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import me.chanjar.aop.aspect.FooAspect;
import me.chanjar.aop.config.AopConfig;
import me.chanjar.aop.service.FooService;
import me.chanjar.aop.service.FooServiceImpl;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.util.AopTestUtils;
import org.testng.annotations.Test;

/**
 * 1、启用了MockitoTestExecutionListener，这样能够开启Mockito的支持
 * 2、@SpyBean private FooAspect fooAspect，这样能够声明一个被Mockito.spy过的Bean
 * 3、verify(fooAspect, times(2)).changeIncrementAndGet(any())，使用Mockito测试FooAspect.changeIncrementAndGet是否被调用了两次
 */
@ContextConfiguration(classes = {SpringAop_2_Test.class, AopConfig.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class SpringAop_2_Test extends AbstractTestNGSpringContextTests {

    /* spy会执行MockBean的实际方法 */
    @SpyBean
    private FooAspect fooAspect;

    @Autowired
    private FooService fooService;

    @Test
    public void testFooService() {

        assertNotEquals(fooService.getClass(), FooServiceImpl.class);

        assertTrue(AopUtils.isAopProxy(fooService));
        assertTrue(AopUtils.isCglibProxy(fooService));

        assertEquals(AopProxyUtils.ultimateTargetClass(fooService), FooServiceImpl.class);

        assertEquals(AopTestUtils.getTargetObject(fooService).getClass(), FooServiceImpl.class);
        assertEquals(AopTestUtils.getUltimateTargetObject(fooService).getClass(), FooServiceImpl.class);

        assertEquals(fooService.incrementAndGet(), 0);
        assertEquals(fooService.incrementAndGet(), 0);

        // advised方法没有返回值
        // Aspect不会修改advised方法的返回值（比如：做日志）
        verify(fooAspect, times(2)).changeIncrementAndGet(any());
    }

}
