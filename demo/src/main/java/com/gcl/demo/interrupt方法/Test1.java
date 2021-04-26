package com.gcl.demo.interrupt方法;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test1")
public class Test1 {
    //interrupt方法不仅可以打断正在阻塞的线程，还可以打断正在运行的线程
    //这几个方法都会让线程进入阻塞状态，sleep、wait、join
    //打断sleep的线程, 会清空打断状态，以sleep为例
    public static void main(String[] args)throws InterruptedException {
        Thread thread1 = new Thread(()->{
            try {
                log.debug("thread1线程开始休眠");
                TimeUnit.SECONDS.sleep(10);  //注意：如果是sleep、join、wait方法会在打断之后把打断标记清空，即重置为假
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("主线程开始打断");
        //这里有个要注意的点
        //调用thread1.interrupt()后立即调用thread1.isInterrupted()，
        //有可能在thread1还未完成清除打断标记并抛异常的时候就查看打断标记，此时仍然为true，
        //如果要得到稳定的false，即重置打断标记后的结果，应该在thread1.interrupt()后，
        //sleep一会，给点时间，有点像jvm启动后偏向锁延迟设置的意思。
        thread1.interrupt();
        Thread.sleep(10);
        log.debug("打断标记：{}",thread1.isInterrupted());
    }
}