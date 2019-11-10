package me.chanjar.basic.spring.ex1;

import me.chanjar.basic.service.FooService;
import me.chanjar.basic.service.FooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 必须注意且缺一不可的三点：
 * 1、测试类继承了[AbstractTestNGSpringContextTests]，如果不这么做测试类是无法启动Spring容器
 * 2、使用了[@ContextConfiguration]来加载被测试的Bean：FooServiceImpl
 * 3、FooServiceImpl是 @Component
 */
@ContextConfiguration(classes = FooServiceImpl.class)
public class FooServiceImplTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private FooService foo;

  @Test
  public void testPlusCount() throws Exception {
    assertEquals(foo.getCount(), 0);

    foo.plusCount();
    assertEquals(foo.getCount(), 1);
  }

}
