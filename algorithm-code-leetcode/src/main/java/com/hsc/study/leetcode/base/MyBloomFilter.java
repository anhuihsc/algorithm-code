package com.hsc.study.leetcode.base;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author hsc
 * @date 2021/4/3
 */
public class MyBloomFilter {
    private final static int DEFAULT_SIZE = 1024 * 1024;
    private int size;
    private BitSet bitSet;
    private List<HashFunction> hashFunctions = new ArrayList<>(8);

    public MyBloomFilter() {
        for (int i = 0; i < 3; i++) {
            hashFunctions.add(new HashFunction(i + 2));
        }
        bitSet = new BitSet(DEFAULT_SIZE);
        size = DEFAULT_SIZE;
    }

    private int getBitIndex(int hash) {
        return (size - 1) & hash;
    }

    public void add(String value) {
        if (value == null) {
            return;
        }
        for (HashFunction f : hashFunctions) {
            bitSet.set(getBitIndex(f.hash(value)), true);
        }
    }

    public boolean containValue(String value) {
        if (value == null) {
            return false;
        }
        for (HashFunction f : hashFunctions) {
            boolean result = bitSet.get(getBitIndex(f.hash(value)));
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private static class HashFunction {
        private int seed;

        public HashFunction(int seed) {
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return Math.abs(result);
        }
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter=BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")),10000,0.01);
        for (int i = 0; i < 1000000; i++) {
            bloomFilter.put(String.valueOf(i));
        }
        System.out.println(bloomFilter.mightContain("121212"));
    }
}
