package com.hsc.study.leetcode.base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * @author wansong
 * @date 2021/7/8
 */
public class MyThread implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(11);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(() -> {
                System.out.println(index + "加入");
                countDownLatch.countDown();
            }).start();
        }
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "懂事长加入");
            countDownLatch.countDown();
        });
        thread.start();
        countDownLatch.await();
        System.out.println("开始会议");

    }
}
