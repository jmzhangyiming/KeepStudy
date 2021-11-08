package com.study.algorithm;

/**
 * @author mrzhang
 * @date 2021/11/5
 */
class AlgotithmJava1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 3, 2, 6, 9};
        Solution1.sort(arr1);
        System.out.print("冒泡法");
        for (int i : arr1) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] arr2 = new int[]{3, 3, 2, 6, 9};
        System.out.print("快速排序");
        Solution2.quickSort(arr2);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

    }

    /**
     * 冒泡法
     */
    public static class Solution1 {
        public static void sort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i ++) {
                for (int j = 0; j < arr.length - 1 - i; j ++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public static class Solution2 {
        public static void quickSort(int[] arr) {
            int length = arr.length;
            if (length > 1) {
                sort(arr, 0, arr.length - 1);
            }
        }

        public static void sort(int[] arr, int low, int high) {
            if (low < high) {
                int middle = getMiddle(arr, low, high);
                sort(arr, 0, middle);
                sort(arr, middle + 1, high);
            }
        }

        public static int getMiddle(int[] arr, int low, int high) {
            int temp = arr[low];
            while (low < high) {
                while (low < high && arr[high] >= temp) {
                    high --;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= temp) {
                    low ++;
                }
                arr[high] = arr[low];
            }
            arr[low] = temp;
            return low;
        }
    }

    /**
     * 插入排序
     */


}
