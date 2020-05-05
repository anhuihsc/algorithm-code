package com.hsc.study.leetcode;

/**
 * @author wansong
 */
public class Test {
    private static int i=0;
    public static void main(String[] args) {
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
