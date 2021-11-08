package com.study.algorithm

/**
 * @author mrzhang
 * @date 2021/11/5
 */

fun main(args: Array<String>) {
    val arr1 = mutableListOf(3, 3, 2, 6, 9)

    println("冒泡法：" + AlgotithmKotlin.Solution1().sort(arr1))
    val arr2 = mutableListOf(3, 3, 2, 6, 9)
    println("快速排序：" + AlgotithmKotlin.Solution2().quickSort(arr2))

}

class AlgotithmKotlin {
    /**
     * 冒泡法
     */
    class Solution1 {
        fun sort(arr: MutableList<Int>): MutableList<Int>{
            for (i in 0 until arr.size - 1) {
                for (j in 0 until arr.size - 1 - i) {
                    if (arr[j] > arr[j + 1]) {
                        val temp = arr[j]
                        arr[j] = arr[j + 1]
                        arr[j + 1] = temp
                    }
                }
            }
            return arr
        }
    }

    /**
     * 快速排序
     */
    class Solution2 {
        fun quickSort(arr: MutableList<Int>): MutableList<Int> {
            if (arr.size > 1) {
                sort(arr, 0, arr.size - 1);
            }
            return arr
        }

        fun sort(arr: MutableList<Int>, low: Int, high: Int) {
            if (low < high) {
                val middle = getMiddle(arr, low, high)
                sort(arr, 0, middle)
                sort(arr, middle + 1, high)
            }
        }

        fun getMiddle(arr: MutableList<Int>, low: Int, high: Int): Int {
            var temp = arr[low]
            var _low = low
            var _high = high
            while (_low < _high) {
                while(_low < _high && arr[_high] >= temp) {
                    _high --;
                }
                arr[_low] = arr[_high];
                while(_low < _high && arr[_low] <= temp) {
                    _low ++;
                }
                arr[_high] = arr[_low]
            }
            arr[_low] = temp
            return _low
        }
    }

    /**
     * 插入排序
     */

}