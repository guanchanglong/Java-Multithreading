package com.gcl.demo.n1;

import com.gcl.demo.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/3/31 18:53
 */
//异步方法
@Slf4j(topic = "c.Async")
public class Async {
    public static final String JPG_FULL_PATH = "D:\\Java多线程学习\\demo2\\src\\main\\resources\\static\\images\\test1.jpg";

    public static void main(String[] args) {
        new Thread(()-> FileReader.read(JPG_FULL_PATH)).start();    //异步调用
        log.debug("do other things...");
    }
}
//结果分析
//18:59:10.344 c.Async [main] - do other things...                              打印日志
//18:59:10.344 c.FileReader [Thread-0] - read [test1.jpg] start ...             这里观察两个时间戳我们可以发现读取文件和打印日志两个是同时进行的
//18:59:10.346 c.FileReader [Thread-0] - read [test1.jpg] end ... cost: 3 ms
