package com.gcl.demo.创建和运行线程;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/1 23:36
 */
@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) {

        //不使用lambada表达式的写法
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                log.debug("running");
//            }
//        };

        //使用lambada表达式简化式子
//        Runnable runnable = ()->{
//            log.debug("running");
//        };

        //也可以使用Thread的构造方法直接设置线程的名字
        //这里直接使用lambada表达式做到了最简
        Thread thread = new Thread(()->log.debug("running"),"线程2");
        thread.start();
        log.debug("running");
    }
}
