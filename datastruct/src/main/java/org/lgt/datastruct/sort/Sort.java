package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 21:52
 **/
public abstract class Sort {
    abstract void sort(int[] array);

    //交换公式 a = b - a + (b = a);
    void swap(int[] array, int a, int b) {
        array[a] = array[b] - array[a] + (array[b] = array[a]);
    }

    void show(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
