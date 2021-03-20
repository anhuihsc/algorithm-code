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

    public static void mergeSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSortUseRecursion(arr, 0, arr.length - 1);
    }

    private static void mergeSortUseRecursion(int arr[], int p, int r) {
        //递归结束条件
        if (p >= r) {
            return;
        }
        //取中间位置
        int q = p + (r - p) / 2;
        mergeSortUseRecursion(arr, p, q);
        mergeSortUseRecursion(arr, q + 1, r);
        //数据做merge(p,r)
        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            left[i] = arr[p + i];
        }
        for (int i = 0; i < r - q; i++) {
            right[i] = arr[q + 1 + i];
        }
        // 第一个数组添加哨兵（最大值）
        left[q - p + 1] = Integer.MAX_VALUE;
        // 第二个数组添加哨兵（最大值）
        right[r - q] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

    }

    private static void print(int arr[]) {
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void quickSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortUseRecursion(arr, 0, arr.length-1);
    }

    private static void quickSortUseRecursion(int arr[], int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        quickSortUseRecursion(arr, p, q);
        quickSortUseRecursion(arr, q + 1, r);

    }

    private static int partition(int arr[], int p, int r) {
        int pivot = arr[p];

        int leftIndex = p;
        for (int index = p + 1; index <= r; index++) {
            //比哨兵大不用处理
            if (arr[index] < pivot) {
                leftIndex++;
                //如果不是一个位置，需要把小的放到左边大的放到右边
                if (leftIndex != index) {
                    int tmp = arr[leftIndex];
                    arr[leftIndex] = arr[index];
                    arr[index] = tmp;
                }
            }
        }
        int tmp = arr[leftIndex];
        arr[leftIndex] = arr[p];
        arr[p] = tmp;
        return leftIndex;
    }



    public static void main(String[] args) {
        int arr[] = {1,3, 2, 13, 4, 5, 6, 8, 9, 12};
        quickSort(arr);
        print(arr);
    }

}
