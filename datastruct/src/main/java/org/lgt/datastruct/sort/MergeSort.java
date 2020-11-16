package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 22:49
 **/
public class MergeSort extends Sort {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int startLeft = left;
        int startRight = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (startLeft <= mid && startRight <= right) {
            if (array[startLeft] < array[startRight]) {
                temp[index++] = array[startLeft++];
            } else {
                temp[index++] = array[startRight++];
            }
        }

        while (startLeft <= mid) {
            temp[index++] = array[startLeft++];
        }
        while (startRight <= right) {
            temp[index++] = array[startRight++];
        }

        startLeft = left;
        for (int value : temp) {
            array[startLeft++] = value;
        }
    }
}
