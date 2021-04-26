package com.gcl.demo.sleep和yield方法;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test3")
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        log.debug("开始睡眠");
        //其实TimeUnit内部也是调用原生的sleep方法，
        //只不过TimeUnit给它进行了一下单位的换算，增加了可读性（不用数那么多个0了...）
        TimeUnit.SECONDS.sleep(1);
        log.debug("结束睡眠");
    }
}
