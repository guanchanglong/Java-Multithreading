package com.gcl.demo.sleep和yield方法;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test2 {
    public static void main(String[] args) {
        Thread thread = new Thread("thread") {
            @Override
            public void run() {
                log.debug("进入睡眠");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("thread线程醒过来了");
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("唤醒thread线程");
        //其它线程可以使用 interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException
        thread.interrupt();
    }
}
//睡眠中的线程被interrupt方法唤醒的这一个代码过程
