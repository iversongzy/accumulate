package org.lgt.datastruct.search;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/10/21 23:52
 **/
public class BinarySearch {
    public int binarySearchByNonRecursion(int[] array, int size, int target) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchByRecursion(int[] array, int size, int target) {
        return searchInternally(array, 0, size - 1, target);
    }

    private int searchInternally(int[] arr, int min, int max, int target) {
        if (min > max) {
            return -1;
        }
        int mid = min + ((max - min) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return searchInternally(arr, mid + 1, max, target);
        } else {
            return searchInternally(arr, min, mid - 1, target);
        }
    }
}
