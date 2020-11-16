package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 22:49
 **/
public class SelectSort extends Sort {
    @Override
    public void sort(int[] array) {
        selectSort1(array);
    }

    private void selectSort1(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            ////每次遍历找到最小值
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, i, min);
            }
        }
    }
}
