package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
    @Test
    public void contextLoads() {
    }

    /**
     *   测试 日志级别：
     *    级别由低到高： trace < debug < info < warm < error  设置的级别越低显示的日志信息越多。
     *    可以调整输出的日志级别，只会显示高于设置级别的日志。
     */
    @Test
    public void testLog() {
        log.trace("这是track日志。。。");
        log.debug("这是debug日志。。。");
        //spring 默认设置的级别是info级别，没有指定级别的情况下，会使用spring默认的root级别（显示的是info级别的信息）
        log.info("这是info日志。。。");
        log.warn("这是warm日志。。。");
        log.error("这是error日志。。。");
    }


}
