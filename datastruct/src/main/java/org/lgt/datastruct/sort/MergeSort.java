package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/9 22:49
 **/
public class MergeSort extends Sort {
    private int a = 0;
    @Override
    public void sort(int[] array) {
        //mergeSort(array, 0, array.length - 1);
        mergeSort2(array);
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

    private void mergeSort2(int[] nums) {

        int len;
        if (nums == null || (len = nums.length) <= 0) {
            return;
        }
        int[] tempArray = new int[len];
        mSort(nums, 0, len, tempArray);
    }

    private void mSort(int[] nums, int left, int right, int[] tempArray) {
        if (left >= right || left + 1 >= right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        mSort(nums, left, middle, tempArray);
        mSort(nums, middle, right, tempArray);

        int leftSubArrayIndex = left;
        int rightSubArrayIndex = middle;
        int currentIndex = left;
        while (leftSubArrayIndex < middle || rightSubArrayIndex < right) {
            if (rightSubArrayIndex >= right || leftSubArrayIndex < middle && nums[leftSubArrayIndex] <= nums[rightSubArrayIndex]) {
                tempArray[currentIndex++] = nums[leftSubArrayIndex++];
                a += rightSubArrayIndex - middle;
            } else {
                tempArray[currentIndex++] = nums[rightSubArrayIndex++];
            }
        }
        System.arraycopy(tempArray, left, nums, left, right - left);
    }
}
