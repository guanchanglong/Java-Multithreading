package com.gcl.demo.join方法;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    static int r = 0;
    public static void main(String[] args) throws InterruptedException{
        test1();
    }
    public static void test1()throws InterruptedException{
        log.debug("开始");
        Thread thread1 = new Thread(()->{
            log.debug("thread1线程开始");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("休眠结束");
            r = 10;
        });
        thread1.start();
        //这里使用了join方法，
        //使主线程等待thread1线程执行结束之后再接着运行
        thread1.join();
        log.debug("结果为：{}",r);
        log.debug("结束");
    }
}
//观察join的底层可以发现，join底层使用是wait方法来实现的（震惊）
//结果：
//17:28:03.277 c.Test1 [main] - 开始
//17:28:03.312 c.Test1 [Thread-0] - thread1线程开始
//17:28:03.312 c.Test1 [main] - 结果为：0
//17:28:03.313 c.Test1 [main] - 结束
//17:28:03.314 c.Test1 [Thread-0] - 休眠结束

//分析，
//因为主线程和thread1线程是异步执行的，
//thread1线程需要 1 秒之后才能算出 r=10,
//而主线程在一开始就打印出 r 的结果，所以只能打印出 r=0
