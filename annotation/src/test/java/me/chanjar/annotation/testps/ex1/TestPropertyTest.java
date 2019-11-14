package me.chanjar.annotation.testps.ex1;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;

import java.util.Map;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * [@TestPropertySource]可以用来覆盖掉来自于系统环境变量、Java系统属性、[@PropertySource]的属性
 */
@ContextConfiguration(classes = PropertySourceConfig.class)
@TestPropertySource(
        properties = {"foo=xyz", "bar=uvw", "PATH=aaa", "java.runtime.name=bbb"},
        locations = "classpath:me/chanjar/annotation/testps/ex1/test-property-source.properties"
)
public class TestPropertyTest extends AbstractTestNGSpringContextTests implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        Map<String, Object> systemEnvironment = ((ConfigurableEnvironment) environment).getSystemEnvironment();
        System.out.println("=== System Environment ===");
        System.out.println(getMapString(systemEnvironment));
        System.out.println();

        System.out.println("=== Java System Properties ===");
        Map<String, Object> systemProperties = ((ConfigurableEnvironment) environment).getSystemProperties();
        System.out.println(getMapString(systemProperties));
    }

    /**
     * [@TestPropertySource]中properties属性 "foo=xyz" 覆盖 [@PropertySource] 引入的 property-source.properties 中的 foo=abc
     */
    @Test
    public void testOverridePropertySource() {
        assertEquals(environment.getProperty("foo"), "xyz");
    }

    /**
     * [@TestPropertySource]中properties属性 "PATH=aaa" 覆盖 系统环境变量
     */
    @Test
    public void testOverrideSystemEnvironment() {
        assertEquals(environment.getProperty("PATH"), "aaa");
    }

    /**
     * [@TestPropertySource]中properties属性 "java.runtime.name=bbb" 覆盖 Java系统属性
     */
    @Test
    public void testOverrideJavaSystemProperties() {
        assertEquals(environment.getProperty("java.runtime.name"), "bbb");
    }

    /**
     * [@TestPropertySource]中properties属性 "bar=uvw" 覆盖 locations 引入的 test-property-source.properties 中的 bar=def
     */
    @Test
    public void testInlineTestPropertyOverrideResourceLocationTestProperty() {
        assertEquals(environment.getProperty("bar"), "uvw");
    }

    private String getMapString(Map<String, Object> map) {
        return String.join("\n",
                map.keySet().stream().map(k -> k + "=" + map.get(k)).collect(toList())
        );
    }
}
