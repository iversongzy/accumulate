package org.lgt.datastruct.heap;

import javax.xml.bind.annotation.XmlType;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/3/23 20:43
 **/
public class MaxHeap {
    private static final int DEFAULT_CAPACITY = 100;
    private int[] array;
    private int size = 0;

    public MaxHeap() {
        this.array = new int[100];
    }

    public MaxHeap(int len) {
        this.array = new int[len];
    }

    public int pop() {
        int res = array[0];
        array[0] = array[--size];
        sink(0);
        return res;
    }


    private void sink(int i) {
        int tempCursor;
        int target = array[i];
        while ((tempCursor = (i << 1) + 1) < size) {
            if (tempCursor < size - 1 && array[tempCursor] < array[tempCursor + 1]) {
                tempCursor++;
            }
            if (array[tempCursor] > target) {
                array[i] = array[tempCursor];
                i = tempCursor;
            } else {
                break;
            }
        }
        array[i] = target;
    }

    public void push(int v) {
        array[size++] = v;
        swim(size - 1);
    }

    private void swim(int i) {
        int target = array[i];
        int parentCursor = 0;
        while (i > 0) {
            parentCursor = (i - 1) / 2;
            if (array[parentCursor] < target) {
                array[i] = array[parentCursor];
                i = parentCursor;
            } else {
                break;
            }
        }
        array[i] = target;
    }
}
