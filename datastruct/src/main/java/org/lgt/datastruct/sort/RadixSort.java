package org.lgt.datastruct.sort;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/16 21:22
 **/
public class RadixSort extends Sort {
    @Override
    void sort(int[] array) {
        radixSort(array);
    }

    private void radixSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int max = array[0];
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        //最大值位数
        int maxLength = String.valueOf(max).length();
        //定义一个二维数组，表示有10个桶，每一个桶的大小为数组的长度（防止溢出），
        int[][] ultraBuckets = new int[10][len];
        //定义一个一维数组记录每个桶中的数据个数
        int[] ultraArray = new int[10];
        for (int i = 0; i < maxLength; i++) {
            //将数据放入桶中(每轮按照个 十 百 千 万的顺序放入对应的桶中)
            for (int j = 0; j < len; j++) {
                int num = (int) (array[j] / Math.pow(10, i) % 10);
                ultraBuckets[num][ultraArray[num]++] = array[j];
            }
            int index = 0;
            //再将桶中数据按顺序倒出到原数组中
            for (int j = 0; j < ultraArray.length; j++) {
                if (ultraArray[j] != 0) {
                    for (int k = 0; k < ultraArray[j]; k++) {
                        array[index++] = ultraBuckets[j][k];
                    }
                }
                ultraArray[j] = 0;
            }
        }
    }
}
