package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 21:55
 **/
public class BubbleSort extends Sort {
    @Override
    public void sort(int[] array) {
        bubblesort3(array);
    }

    private void bubblesort1(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void bubblesort2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //如果一趟比较下来没有交换说明有序
        boolean flag;
        for (int i = array.length - 1; i >= 0; i--) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    private void bubblesort3(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int lastExchangeIndex = 0;
        boolean flag;
        int index = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            flag = true;
            for (int j = 0; j < index; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                    //更新最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            index = lastExchangeIndex;
            if (flag) {
                break;
            }
        }
    }


}
