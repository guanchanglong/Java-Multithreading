package com.gcl.demo.interrupt方法;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(() -> {
            while (true) {
                //打断正在运行的线程不会清空线程状态
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){
                    log.debug("被打断了，退出循环");
                    break;
                }
            }
        }, "thread");
        thread.start();
        Thread.sleep(1000);
        log.debug("打断");
//        注意：这里的打断并不能是指线程打断之后 thread 线程就停止运行了，
//        而是被打断之后 thread 线程还会继续运行着，相当于稍微被暂停了一会儿
//        简单地理解：
//        所以我们这里的interrupt方法本质不是用来中断一个线程。是将线程设置一个中断状态
//        想要真正中断线程的话，还是需要我们自己写代码
        thread.interrupt();
    }
}
