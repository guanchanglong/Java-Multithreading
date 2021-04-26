package com.gcl.demo.两阶段终止模式;

public class Test1 {
    public static void main(String[] args) {

    }
}
//两阶段终止模式
//在一个线程 T1 中如何“优雅”终止线程 T2？这里的【优雅】指的是给 T2 一个料理后事的机会。
//1. 错误思路
//使用线程对象的 stop() 方法停止线程
//stop 方法会真正杀死线程，如果这时线程锁住了共享资源，那么当它被杀死后就再也没有机会释放锁，
//其它线程将永远无法获取锁
//使用 System.exit(int) 方法停止线程
//目的仅是停止一个线程，但这种做法会让整个程序都停止
