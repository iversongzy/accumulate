package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 22:49
 **/
public class InsertSort extends Sort {

    @Override
    public void sort(int[] array) {
        insertSort2(array);
    }

    private void insertSort1(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int tempValue = array[i];
            int j = i;
            for (; j > 0; j--) {
                if (array[j - 1] > tempValue) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = tempValue;
        }
    }

    private void insertSort2(int[] array) {
        //为什么从1开始，因为将0作为有序表，1以后的作为无序表插入过去
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                swap(array, j - 1, j);
            }
        }
    }
}
