package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/16 20:43
 **/
public class CountSort extends Sort {

    @Override
    void sort(int[] array) {
        countSort(array);
    }

    private void countSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int max = array[0];
        int min = array[0];
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        //优化,减小范围
        int range = max - min + 1;
        int[] countArray = new int[range];
        for (int i = 0; i < len; i++) {
            countArray[(array[i] - min)]++;
        }
        //统计当前<=此数(下标)的个数
        for (int i = 1; i < range; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        int[] sortedArray = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            //-1是因为数组下标从0开始
            int index = countArray[array[i] - min] - 1;
            sortedArray[index] = array[i];
            countArray[(array[i] - min)]--;
        }
        for (int i = 0; i < len; i++) {
            array[i] = sortedArray[i];
        }
    }
}

