package com.gcl.demo.创建和运行线程;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/1 23:27
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        //以匿名内部类的方法创建一个线程对象
        Thread thread = new Thread(){
            @Override
            public void run(){
                log.debug("running");
            }
        };


        //指定线程的名字
        thread.setName("线程1");
        //启动线程
        thread.start();

        log.debug("running");
    }
}
