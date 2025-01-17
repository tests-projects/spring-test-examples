package me.chanjar.spring2;

import static org.testng.Assert.assertEquals;

import me.chanjar.domain.Foo;
import me.chanjar.domain.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 继承AbstractTransactionalTestNGSpringContextTests，每个测试方法在执行完毕后，会自动rollback
 */
@ContextConfiguration(classes = Spring_2_IT_Configuration.class)
public class Spring_2_IT extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private FooRepository fooRepository;

    @Test
    public void testSave() {
        Foo foo = new Foo();
        foo.setName("Bob");
        fooRepository.save(foo);

        assertEquals(countRowsInTable("FOO"), 1);
        countRowsInTableWhere("FOO", "name = 'Bob'");
    }

    @Test(dependsOnMethods = "testSave")
    public void testDelete() {
        assertEquals(countRowsInTable("FOO"), 0);

        Foo foo = new Foo();
        foo.setName("Bob");
        fooRepository.save(foo);

        fooRepository.delete(foo.getName());
        assertEquals(countRowsInTable("FOO"), 0);
    }

}
