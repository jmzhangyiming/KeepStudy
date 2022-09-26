package com.study.algorithm;

/**
 * 排序算法
 */
class AlgotithmJava1 {

    public static void main(String[] args) {
        // 冒泡排序
        int[] arr1 = {2, 8, 5, 11, 6};
        bubbleSort(arr1);
        System.out.println("冒泡排序");
        for (int i : arr1) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 快速排序
        int[] arr2 = {2, 6, 3, 4, 6};
        quickSort(arr2);
        System.out.println("快速排序");
        for (int i : arr2) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 插入排序
        int[] arr3 = {2, 9, 11, 4, 6};
        insertSort(arr3);
        System.out.println("插入排序");
        for (int i : arr3) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 归并排序
        int[] arr4 = {2, 7, 3, 9, 6};
        mergeSort(arr4);
        System.out.println("归并排序");
        for (int i : arr4) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 选择排序
        int[] arr5 = {2, 11, 13, 9, 7};
        mergeSort(arr5);
        System.out.println("选择排序");
        for (int i : arr5) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 希尔排序
        int[] arr6 = {2, 11, 13, 9, 7};
        sheelSort(arr6);
        System.out.println("希尔排序");
        for (int i : arr6) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 堆排序
        int[] arr7 = {2, 11, 5, 22, 7};
        heapSort(arr7);
        System.out.println("堆排序");
        for (int i : arr7) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 基数排序
        int[] arr8 = {2, 11, 33, 22, 1};
        baseSort(arr8);
        System.out.println("基数排序");
        for (int i : arr8) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 二分查找法
        int[] arr9 = {2, 11, 33, 22, 1};
        boolean have = binarySearch(arr9, 11, 0, arr9.length - 1);
        System.out.println("二分法查找");
        System.out.print(have);
    }

    /**
     * 冒泡排序（时间复杂度O(n²)，空间复杂度O(1)，稳定）
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = 0; j < arr.length - 1 - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序（时间复杂度，最好情况O(nlogn)，最坏情况O(n²)，空间复杂度O(logn)~O(n)，不稳定）
     */
    public static void quickSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        quick_sort(arr, 0, length - 1);
    }

    public static void quick_sort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quick_sort(arr, low, middle - 1);
            quick_sort(arr, middle + 1, high);
        }
    }

    public static int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high --;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= temp) {
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    /**
     * 插入排序（时间复杂度，最好情况O(n)，最坏情况O(n²)，空间复杂度O(1)，不稳定）
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            int j = i - 1;
            int insertNum = arr[i];
            while (j >= 0 && arr[j] > insertNum) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = insertNum;
        }
    }

    /**
     * 归并排序（时间复杂度O(nlogn)，空间复杂度O(n)，稳定）
     */
    public static void mergeSort(int[] arr) {
        merge_sort(arr, 0, arr.length - 1);
    }

    public static void merge_sort(int[] arr, int low, int high) {
        if(low < high) {
            int center = (low + high)/2;
            merge_sort(arr, low, center);
            merge_sort(arr, center + 1, high);
            merge(arr, low, center, high);
        }
    }

    public static void merge(int[] arr, int low, int center, int high) {
        int[] tempArr = new int[arr.length];
        int mid = center + 1;
        int third = low;
        int temp = low;
        while (low <= center && mid <= high) {
            if (arr[low] <= arr[mid]) {
                tempArr[third ++] = arr[low ++];
            } else {
                tempArr[third ++] = arr[mid ++];
            }
        }
        while (low <= center) {
            tempArr[third ++] = arr[low ++];
        }
        while (mid <= high) {
            tempArr[third ++] = arr[mid ++];
        }
        while(temp <= high) {
            arr[temp] = tempArr[temp ++];
        }
    }

    /**
     * 选择排序（时间复杂度O(n²)，空间复杂度O(1)，不稳定）
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = arr.length - 1; j > i; j --) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    /**
     * 希尔排序（时间复杂度和跨度step有关系，时间复杂度最好的是O(n)，最坏的情况根据step的不同可做到O(n^1.3)~O(n²),空间复杂度O(1)，不稳定）
     */
    public static void sheelSort(int[] arr) {
        int step = arr.length;
        while(step != 0) {
            step = step/2;
            for (int i = 0; i < step; i ++) {
                for (int j = i + step; j < arr.length; j += step) {
                    int k = j - step;
                    int temp = arr[j];
                    while (k > 0 && temp < arr[k]) {
                        arr[k + step] = arr[k];
                        k -= step;
                    }
                    arr[k + step] = temp;
                }
            }
        }
    }

    /**
     * 堆排序（时间复杂度O(nlogn)，空间复杂度O(1)，不稳定）
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 循环建堆
        for (int i = 0; i < len - 1; i ++) {
            // 建堆
            buildMaxHeap(arr, len - 1 - i);
            // 交换堆顶和最后一个元素
            swap(arr, 0, len - 1 - i);
        }
    }

    public static void buildMaxHeap(int[] arr, int lastIndex) {
        // 从最后一个节点的父节点开始处理
        for (int i = (lastIndex - 1)/2; i >= 0; i --) {
            // 当前节点
            int k = i;
            // 如何当前节点存在子节点
            while (k * 2 + 1 <= lastIndex) {
                // 当前节点的左子节点
                int bigger = 2 * k + 1;
                // 如果左子节点小于lastIndex，证明存在右子节点
                if (bigger < lastIndex) {
                    // 比较左右节点，取出较大的节点
                    if (arr[bigger] < arr[bigger + 1]) {
                        // bigger记录较大的子节点
                        bigger ++;
                    }
                }
                // 如果当前节点小于较大的子节点，则交换
                if (arr[k] < arr[bigger]) {
                    swap(arr, k, bigger);
                    k = bigger;
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 基数排序（n为数据规模，r数据进制（2进制、10进制、16进制）,d为最大数据位数，时间复杂度(nd)，空间复杂度(n+d)）
     */
    public static void baseSort(int[] arr) {
        // 确定最大值
        int max = arr[0];
        for (int i = 1; i < arr.length - 1; i ++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 确定排序的轮数（最大值的长度）
        int maxLenght = (max + "").length();
        // 创建桶,0~9是10个数字，因此是10个桶,使用数组的话需要创建每个桶的长度是arr的长度，避免所有的数落到同一个桶里
        // 使用ArrayList可节省空间
        int[][] bucket = new int[10][arr.length];
        // 记录每个桶中存放了多少数据
        int[] bucketElemCount = new int [10];
        // 开始分类收集,从个位开始处理，个位r是1
        for (int r = 1; r <= maxLenght; r ++) {
            // 分桶
            for (int i = 0; i < arr.length; i ++) {
                // 得到对应r位数上的数字
                int ret = 0;
                // 要得到位数上数字的arr中的数据
                int num = arr[i];
                for (int j = 1; j <= r; j++) {
                    ret = num % 10;
                    num /= 10;
                }
                // 放到对应的桶里
                bucket[ret][bucketElemCount[ret] ++] = arr[i];
            }
            int index = 0;
            // 遍历每一个桶，并将桶中的数据放入到原始组中去
            for (int k = 0; k < bucketElemCount.length; k ++) {
                for (int l = 0; l < bucketElemCount[k]; l++) {
                    arr[index ++] = bucket[k][l];
                }
                bucketElemCount[k] = 0;
            }
        }
    }

    /**
     * 二分查找，解决有序数列查找问题(时间复杂度O(nlogn)，空间复杂度O(1))
     */
    public static boolean binarySearch(int[] arr, int value,int low, int high) {
        int mid = (low + high)/2;
        if (value == arr[mid]) {
            return true;
        }
        if (arr[mid] < value) {
            return binarySearch(arr, value,mid + 1, high);
        }
        if (arr[mid] > value) {
            return binarySearch(arr, value, low, mid - 1);
        }
        return false;
    }

}
