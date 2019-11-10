package me.chanjar.basic.spring.ex2;

import me.chanjar.basic.service.FooService;
import me.chanjar.basic.service.FooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@ContextConfiguration
public class FooServiceImplTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private FooService foo;

  @Test
  public void testPlusCount() throws Exception {
    assertEquals(foo.getCount(), 0);

    foo.plusCount();
    assertEquals(foo.getCount(), 1);
  }

  /**
   * 根据[@ContextConfiguration]的文档，
   * 它会在默认情况下查找测试类的nested static @Configuration class，用它来导入Bean
   */
  @Configuration
  @Import(FooServiceImpl.class)
  static class Config {
  }

}
