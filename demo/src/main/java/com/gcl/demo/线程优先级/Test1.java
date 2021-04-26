package com.gcl.demo.线程优先级;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           int count = 0;
           for (;;){
               System.out.println("--->thread1 "+count++);
           }
        });
        Thread thread2 = new Thread(()->{
           int count = 0;
           for (;;){
               //这里使用yield来限制thread的时间片，
               //使得thread1分到的时间片更多，我们可以通过打印的数字来看出
//               Thread.yield();
               System.out.println("             ---->thread2 "+count++);
           }
        });
        thread1.setName("thread1");
        thread2.setName("thread2");
        //通过观察这里的运行结果，我们可以看到，如果运行的越久，
        //即CPU越繁忙，则thread1被调用的几率大大减少，而thread2线程被调用的几率大大增加；
        //反之，如果一运行就停止下来的话，他们两个被调用的几率其实没有太大的差别
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
//线程优先级会提示（hint）调度器优先调度该线程，但它仅仅是一个提示，调度器可以忽略它(所以它很不靠谱)
//MIN_PRIORITY = 1  是最小的优先级
//NORM_PRIORITY = 5 是默认的优先级
//MAX_PRIORITY = 10 是最高的优先级
//总的来说就是数字越大优先级越高

//如果 CPU 比较忙，那么优先级高的线程会获得更多的时间片，但 CPU 闲时，优先级几乎没作用
