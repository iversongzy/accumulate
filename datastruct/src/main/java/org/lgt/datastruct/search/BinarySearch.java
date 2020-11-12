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

    /**
     * 查找第一个值等于给定值的元素
     */
    public int bSearchFindFirst(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public int bSearchFindLast(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public int bSearchFindMore(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] >= value) {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个小于等于给定值的元素
     */
    public int bSearchFindLess(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] <= value) {
                if (mid == array.length - 1 || array[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
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
