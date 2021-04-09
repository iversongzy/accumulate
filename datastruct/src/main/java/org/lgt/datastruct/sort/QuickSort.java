package org.lgt.datastruct.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 22:49
 **/
public class QuickSort extends Sort {

    @Override
    public void sort(int[] array) {
        //quickSort(array, 0, array.length - 1);
        quickSort2(array);
        Arrays.sort(array);
    }

    public void quickSort(int[] arr, int left, int right) {
        //递归终结条件
        if (left >= right) {
            return;
        }
        //确定基准元素位置
        int pivot = partition3(arr, left, right);
        //根据基准元素，分成两部分进行递归排序
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public void quickSort2(int[] arr) {
        if(arr == null) {
            return;
        }
        qSort(arr, 0, arr.length);

    }

    private void qSort(int[] arr, int begin, int end) {
        if(begin >= end || begin+1 >= end) {
            return;
        }
        int left = begin;
        int current = begin;
        int right = end - 1;
        int middle = begin + ((end - begin) >> 1);
        final int middleValue = arr[middle];
        while (current <= right) {
            if(arr[current] < middleValue) {
                swap(arr, current++, left++);
            } else if(arr[current] == middleValue) {
                current++;
            } else {
                swap(arr, current, right--);
            }
        }
        qSort(arr, begin, left);
        qSort(arr, current, end);
    }

    private int partition1(int[] arr, int left, int right) {
        int lCursor = left;
        int rCursor = right;
        //注意选择基准点的位置
        int pivot = arr[left];
        while (lCursor < rCursor) {
            //注意哪边光标先移动以及=号位置，如果基准点选在左边让右边光标先动，把=放在左边能跳过基准值
            while (lCursor < rCursor && arr[rCursor] > pivot) {
                rCursor--;
            }
            while (lCursor < rCursor && arr[lCursor] <= pivot) {
                lCursor++;
            }
            if (lCursor < rCursor) {
                swap(arr, lCursor, rCursor);
            }
        }
        arr[left] = arr[lCursor];
        arr[lCursor] = pivot;
        return lCursor;
    }

    public static int partition2(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //有顺序要求，基准选在左边，先让右光标移动，这个=在哪边无所谓
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            //找到右边不符合条件(肯定在左边)的就和左边交换，并让左边光标加1，因为左边多了一个符合条件的
            if (low < high) {
                arr[low++] = arr[high];
            }

            while (low < high && arr[low] < pivot) {
                low++;
            }

            if (low < high) {
                arr[high--] = arr[low];
            }
        }
        arr[low] = pivot;
        return low;
    }

    public int partition3(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return divide(nums, l, r);
    }

    public int divide(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        //i表示比基准值小的数
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

}
