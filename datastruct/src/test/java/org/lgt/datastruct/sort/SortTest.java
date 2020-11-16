package org.lgt.datastruct.sort;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/12 23:33
 **/
public class SortTest {
    //int[] array = {-1,2,-8,-10};
    int[] array = {6,9,3,7,2,8,4};
    @Test
    public void bubbleSortTest() {
        BubbleSort sort = new BubbleSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void insertSortTest() {
        InsertSort sort = new InsertSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void selectSortTest() {
        SelectSort sort = new SelectSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void mergeSortTest() {
        MergeSort sort = new MergeSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void quickSortTest() {
        QuickSort sort = new QuickSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void countSortTest() {
        CountSort sort = new CountSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void bucketSortTest() {
        BucketSort sort = new BucketSort();
        sort.sort(array);
        sort.show(array);
    }

    @Test
    public void radixSortTest() {
        RadixSort sort = new RadixSort();
        sort.sort(array);
        sort.show(array);
    }

}