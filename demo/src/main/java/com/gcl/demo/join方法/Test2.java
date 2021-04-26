package com.gcl.demo.join方法;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    static int t1 = 0;
    static int t2 = 0;
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(()->{
            log.debug("thread1开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1 = 10;
            log.debug("thread1结束");
        });
        Thread thread2 = new Thread(()->{
            log.debug("thread2开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t2 = 20;
            log.debug("thread2结束");
        });
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        //等待thread1和thread2线程都执行完后，
        //再执行主线程下面的语句
        thread1.join();
        thread2.join();
        log.debug("t1的值：{}",t1);
        log.debug("t2的值：{}",t2);
        long end = System.currentTimeMillis();
        log.debug("总的花费的时间：{}",end-start);
    }
}
//关于join的一个案例，多个线程同步等待，判断该程序一共花费多少秒执行，答案应该是2秒

//结果：
//18:23:26.388 c.Test2 [Thread-0] - thread1开始
//18:23:26.388 c.Test2 [Thread-1] - thread2开始
//18:23:27.391 c.Test2 [Thread-0] - thread1结束
//18:23:28.391 c.Test2 [Thread-1] - thread2结束
//18:23:28.391 c.Test2 [main] - t1的值：10
//18:23:28.397 c.Test2 [main] - t2的值：20
//18:23:28.397 c.Test2 [main] - 总的花费的时间：2011

//分析：
//第一个 join：等待 t1 时, t2 并没有停止, 而在运行
//第二个 join：1s 后, 执行到此, t2 也运行了 1s, 因此也只需再等待 1s