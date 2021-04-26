package com.gcl.demo.start和run方法;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test")
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread("thread1"){
            @Override
            public void run(){
                log.debug("running...");
            }
        };

        System.out.println("线程启动之前的状态："+thread1.getState());
        //直接执行run方法的话是达不到多线程的目的的，
        //此时还是主线程在调用run方法，而不是thread1线程
//        thread1.run();
        thread1.start();
        System.out.println("线程启动之后的状态："+thread1.getState());
        log.debug("running in main");
    }
}
//总结：
//直接调用 run 是在主线程中执行了 run，没有启动新的线程
//使用 start 是启动新的线程，通过新的线程间接执行 run 中的代码