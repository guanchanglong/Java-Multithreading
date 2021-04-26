package com.gcl.demo.join方法;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test3")
public class Test3 {
    static int t1 = 0;
    static int t2 = 0;
    public static void main(String[] args) throws InterruptedException{
        test3();
    }
    public static void test3()throws InterruptedException{
        Thread thread1 = new Thread(()->{
            try{
                //休眠2秒钟
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            t1 = 10;
        });
        long start = System.currentTimeMillis();
        thread1.start();
        //线程执行结束会导致join结束
        log.debug("开始join等待");
        //等待1.5秒钟，如果超过该时间限制线程仍未结束则不再等待
        thread1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("t1：{},t2：{},花费的时间：{}",t1,t2,end-start);
    }
}
