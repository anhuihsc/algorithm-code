package com.hsc.study.leetcode.base;

/**
 * @author wansong
 * @date 2021/2/21
 */
public class Sorts {

    /**
     * 一次冒泡会让至少一个元素移动到它应该在的位置
     * 从小到大
     */
    public static void bubbleSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        //需要n次冒泡
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                //交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    private static void print(int arr[]) {
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 3, 7, 6, 8, 9, 12};
        bubbleSort(arr);
        print(arr);
    }

}
