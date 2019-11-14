package me.chanjar.annotation.jsontest.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import me.chanjar.annotation.jsontest.ex1.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * [@JsonTest]可以用来测试[@JsonComponent]。
 */
@JsonTest
@SpringBootTest(classes = {JsonComponentJacksonTest.class, FooJsonComponent.class})
public class JsonComponentJacksonTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private JacksonTester<Foo> jacksonTester;

    @Test
    public void testSerialize() throws Exception {
        Foo details = new Foo("Honda", 12);

        assertThat(this.jacksonTester.write(details).getJson()).isEqualTo("\"name=Honda,age=12\"");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "\"name=Ford,age=13\"";
        Foo actual = this.jacksonTester.parseObject(content);

        assertThat(actual).isEqualTo(new Foo("Ford", 13));
        assertThat(actual.getName()).isEqualTo("Ford");
        assertThat(actual.getAge()).isEqualTo(13);
    }

}
