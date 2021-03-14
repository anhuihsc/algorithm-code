package com.hsc.study.leetcode.base;

/**
 * @author wansong
 * @date 2021/2/21
 */
public class Sorts {

    /**
     * 一次冒泡会让至少一个元素移动到它应该在的位置，所以最坏情况需要扫描n次
     * 只会操作相邻的两个数据，内循环是比较相邻的两个元素
     */
    public static void bubbleSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        //是否存在交换的标志位
        boolean existSwap = false;
        //需要n次冒泡
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                //交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;

                    existSwap = true;
                }
            }
            // 没有数据交换，提前退出
            if (!existSwap) {
                break;
            }

        }
    }

    /**
     * 插入排序
     *
     */
    public static void insertSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        //
        for (int i = 1; i < len; i++) {
            int value = arr[i];
            int j = i - 1;
            // 和前面进行比较，数据后移动
            for (; j >= 0; j--) {
                //数据移动
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //插入合适的数据
            arr[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     */
    public static void selectSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        // 每次选择一个元素
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换选择出来的最小值,放到相应的位置
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    private static void print(int arr[]) {
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 3, 4, 5, 6, 8, 9, 12};
        selectSort(arr);
        print(arr);
    }

}
