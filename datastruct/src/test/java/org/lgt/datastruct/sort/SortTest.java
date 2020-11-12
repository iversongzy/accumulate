package org.lgt.datastruct.sort;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/12 23:33
 **/
public class SortTest {
    int[] array = {6,9,3,7,2,8,4};
    @Test
    public void bubbleSortTest() {
        BubbleSort sort = new BubbleSort();
        sort.sort(array);
        sort.show(array);
    }

}