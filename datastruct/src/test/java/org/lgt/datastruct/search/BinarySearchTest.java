package org.lgt.datastruct.search;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/10/22 0:13
 **/
public class BinarySearchTest {
    @Test
    public void binarySearchTest() {
        int[] array = {1,3,5,7,9,11,13,17};
        BinarySearch binarySearch = new BinarySearch();
        int res1 = binarySearch.binarySearchByRecursion(array, array.length, 9);
        System.out.println(res1);
        int res2 = binarySearch.binarySearchByNonRecursion(array, array.length, 9);
        System.out.println(res2);
    }

}