package me.chanjar.basic.springboot.ex4;

import me.chanjar.basic.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 1. 它会尝试加载`@SpringBootTest(classes=...)`的定义的Annotated classes。
 *    Annotated classes的定义在[ContextConfiguration]中有说明。
 * 2. 如果没有设定`@SpringBootTest(classes=...)`，那么会去找当前测试类的nested @Configuration class
 * 3. 如果上一步找到，则会尝试查找`@SpringBootConfiguration`，查找的路径有：
 *    1)看当前测试类是否`@SpringBootConfiguration`，
 *    2)在当前测试类所在的package里找。
 */
@SpringBootTest
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
