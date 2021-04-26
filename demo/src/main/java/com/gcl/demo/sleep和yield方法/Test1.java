package com.gcl.demo.sleep和yield方法;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        Thread thread = new Thread("thread"){
            @Override
            public void run() {
                try {
                    //调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        thread.start();
        log.debug("thread state:{}",thread.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("thread state:{}",thread.getState());
    }
}
//sleep方法
//1. 调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
//2. 其它线程可以使用 interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException
//3. 睡眠结束后的线程未必会立刻得到执行
//4. 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性
//注意：sleep方法写在哪个线程中，它就会让那个线程休眠

//yield方法
//1. 调用 yield 会让当前线程从 Running 进入 Runnable 就绪状态，然后调度执行其它线程
//2. 具体的实现依赖于操作系统的任务调度器

