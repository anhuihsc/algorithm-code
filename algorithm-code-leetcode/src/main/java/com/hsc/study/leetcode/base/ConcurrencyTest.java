package com.hsc.study.leetcode.base;

/**
 * @author wansong
 * @date 2021/7/8
 */
public class ConcurrencyTest {

    public static void main(String[] args) {
        long count = 100000000;
        serial(count);
        concurrency(count);
    }

    private static void serial(final long count) {
        long time0 = System.currentTimeMillis();

        long a = 0;
        for (long i = 0; i < count; i++) {
            a = a + 2;
        }
        long b = 1;
        for (long i = 0; i < count; i++) {
            b = b - 1;
        }
        long costTime = System.currentTimeMillis() - time0;
        System.out.println("serial time:" + costTime);
    }

    private static void concurrency(final long count) {
        long time0 = System.currentTimeMillis();
        new Thread(() -> {
            long a = 0;
            for (long i = 0; i < count; i++) {
                a = a + 2;
            }
        }).start();
        long b = 1;
        for (long i = 0; i < count; i++) {
            b = b - 1;
        }
        long costTime = System.currentTimeMillis() - time0;
        System.out.println("concurrency time:" + costTime);
    }



}
