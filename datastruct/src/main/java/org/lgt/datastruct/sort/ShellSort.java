package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/16 20:43
 **/
public class ShellSort extends Sort {
    @Override
    void sort(int[] array) {
        shellSort(array);
    }

    private void shellSort(int[] array) {
        //设置步长
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - step]) {
                    while (j - step >= 0 && array[j] < array[j - step]) {
                        array[j] = array[j - step];
                        j -= step;
                    }
                    array[j] = temp;
                }
            }
        }
    }
}
