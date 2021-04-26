package com.gcl.demo.n1;

import com.gcl.demo.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/3/30 20:50
 */
//同步调用
@Slf4j(topic = "c.Sync")
public class Sync {
    public static final String JPG_FULL_PATH = "D:\\Java多线程学习\\demo2\\src\\main\\resources\\static\\images\\test1.jpg";

    public static void main(String[] args) {
        FileReader.read(JPG_FULL_PATH);     //同步调用
        log.debug("do other things ...");
    }
}
//结果分析
//18:54:14.809 c.FileReader [main] - read [test1.jpg] start ...             先执行FileReader类下面的read方法
//18:54:14.814 c.FileReader [main] - read [test1.jpg] end ... cost: 6 ms    这里已经执行结束了read方法了
//18:54:14.814 c.Sync [main] - do other things ...                          然后打印日志，这是同步调用，按照代码的执行顺序来输出