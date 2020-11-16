package org.lgt.datastruct.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/16 20:44
 **/
public class BucketSort extends Sort {

    @Override
    void sort(int[] array) {
        bucketSort(array);
    }

    private void bucketSort(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int range = max - min;
        int bucketNum = array.length;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < len; i++) {
            //range/(bucketNum-1)是区间跨度
            int num = (array[i] - min) * (bucketNum - 1) / range;
            bucketList.get(num).add(array[i]);
        }
        for (LinkedList<Integer> list : bucketList) {
            Collections.sort(list);
        }
        int[] sortedArray = new int[len];
        int index = 0;
        for (LinkedList<Integer> list : bucketList) {
            for (Integer value : list) {
                sortedArray[index++] = value;
            }
        }
        for (int i = 0; i < len; i++) {
            array[i] = sortedArray[i];
        }
    }
}
