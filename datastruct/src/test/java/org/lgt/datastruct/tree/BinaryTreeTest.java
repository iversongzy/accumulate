package org.lgt.datastruct.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/19 23:05
 **/
public class BinaryTreeTest {

    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    @Test
    public void binaryTest() {
        LinkedList<Integer> integers = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
    }
}