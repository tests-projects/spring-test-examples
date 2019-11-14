package me.chanjar.no_mock;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Set;
import me.chanjar.common.Bar;
import me.chanjar.common.FooImpl;
import org.testng.annotations.Test;

public class NoMockTest {

    @Test
    public void testCheckCodeDuplicate1() throws Exception {
        FooImpl foo = new FooImpl();

        // 使用Bar匿名类
        foo.setBar(new Bar() {
            @Override
            public Set<String> getAllCodes() {
                return Collections.singleton("123");
            }
        });

        assertEquals(foo.checkCodeDuplicate("123"), true);

    }

    @Test
    public void testCheckCodeDuplicate2() throws Exception {
        FooImpl foo = new FooImpl();

        // 添加一个FakeBar
        foo.setBar(new FakeBar(Collections.singleton("123")));

        assertEquals(foo.checkCodeDuplicate("123"), true);

    }

    public class FakeBar implements Bar {

        private final Set<String> codes;

        public FakeBar(Set<String> codes) {
            this.codes = codes;
        }

        @Override
        public Set<String> getAllCodes() {
            return codes;
        }

    }

}
