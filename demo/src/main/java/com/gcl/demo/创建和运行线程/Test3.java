package com.gcl.demo.创建和运行线程;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/2 0:52
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                log.debug("running");
//                Thread.sleep(5000); //线程休眠5秒
//                return 666;
//            }
//        });

        //lambada表达式简化版
        FutureTask<Integer> task = new FutureTask<>(() -> {
            log.debug("running");
            Thread.sleep(5000); //线程休眠5秒
            return 666;
        });
        Thread thread = new Thread(task,"线程3");
        thread.start();
        log.debug("{}",task.get());
    }
}
