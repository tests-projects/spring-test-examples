package me.chanjar.annotation.overrideac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 在测试代码里关闭AutoConfiguration如何处理?
 *  1.方法1：提供另一套测试配置
 *  2.方法2：使用`@OverrideAutoConfiguration`
 */
@Configuration
public class AutoConfigurationEnableLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoConfigurationEnableLogger.class);

    public AutoConfigurationEnableLogger() {
        LOGGER.info("Auto Configuration Enabled");
    }

}
