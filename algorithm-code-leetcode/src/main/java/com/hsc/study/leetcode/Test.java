package com.hsc.study.leetcode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wansong
 */
public class Test {
    private static int i=0;
    private ReentrantLock lock;
    public static void main(String[] args) {
        synchronized (Test.class) {
            i++;
        }
        System.out.println(i);
     new Thread(new Runnable() {
         public void run() {
             testSyn();
         }
     }).start();
    }

    public static void testSyn() {
        synchronized (Test.class) {
            i++;
        }
        System.out.println(i);
    }
}
