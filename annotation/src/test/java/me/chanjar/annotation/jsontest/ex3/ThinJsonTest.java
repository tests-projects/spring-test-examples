package me.chanjar.annotation.jsontest.ex3;

import static org.assertj.core.api.Assertions.assertThat;

import me.chanjar.annotation.jsontest.ex1.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * [@JsonTest]配合@ContextConfiguration一起使用
 */
@JsonTest
@ContextConfiguration(classes = ThinJsonTest.class)
public class ThinJsonTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private JacksonTester<Foo> jacksonTester;

    @Test
    public void testSerialize() throws Exception {
        Foo details = new Foo("Honda", 12);

        // 或者使用基于JSON path的校验
        assertThat(this.jacksonTester.write(details)).hasJsonPathStringValue("@.name");
        assertThat(this.jacksonTester.write(details)).extractingJsonPathStringValue("@.name").isEqualTo("Honda");
        assertThat(this.jacksonTester.write(details)).hasJsonPathNumberValue("@.age");
        assertThat(this.jacksonTester.write(details)).extractingJsonPathNumberValue("@.age").isEqualTo(12);
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"name\":\"Ford\",\"age\":13}";
        Foo actual = this.jacksonTester.parseObject(content);

        assertThat(actual).isEqualTo(new Foo("Ford", 13));
        assertThat(actual.getName()).isEqualTo("Ford");
        assertThat(actual.getAge()).isEqualTo(13);
    }

}
