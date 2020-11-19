package org.lgt.datastruct.tree;

/**
 * @Description
 * @Author liuguotai
 * @Date2020/11/19 22:58
 **/
public class BinarySearchTree {
    private TreeNode tree;

    public TreeNode search(int data) {
        TreeNode tempNode = tree;
        while (tempNode != null) {
            if (data < tempNode.value) {
                tempNode = tempNode.left;
            } else if (data > tempNode.value) {
                tempNode = tempNode.right;
            } else {
                return tempNode;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }
        TreeNode tempNode = tree;
        while (tempNode != null) {
            if (data > tempNode.value) {
                if (tempNode.right == null) {
                    tempNode.right = new TreeNode(data);
                    return;
                }
                tempNode = tempNode.right;
            } else {
                if (tempNode.left == null) {
                    tempNode.left = new TreeNode(data);
                    return;
                }
                tempNode = tempNode.left;
            }
        }
    }

    public void remove(int data) {
        TreeNode tempNode = tree;
        TreeNode fatherNode = null;
        //找到要删除的节点
        while (tempNode != null && tempNode.value != data) {
            fatherNode = tempNode;
            if (data > tempNode.value) {
                tempNode = tempNode.right;
            } else {
                tempNode = tempNode.left;
            }
        }
        if (tempNode == null) {
            return;
        }
        //如果删除的节点有两个子节点，找到它的右子树的最小节点，替换到删除节点，再删除这个最小节点（最小节点肯定没有左子树）
        if (tempNode.left != null && tempNode.right != null) {
            TreeNode minNode = tempNode.right;
            TreeNode fatherMinNode = tempNode;
            while (minNode.left != null) {
                fatherMinNode = minNode;
                minNode = minNode.left;
            }
            //将找到的最小节点替换到删除节点上
            tempNode.value = minNode.value;
            //删除这个最小节点（接着走下面只有一个子节点或者没有子节点的删除流程）
            tempNode = minNode;
            fatherNode = fatherMinNode;
        }

        TreeNode childNode;
        //如果要删除的点只有一个子节点，只需让它的父节点指向它的那个子节点
        if (tempNode.left != null) {
            childNode = tempNode.left;
        } else if (tempNode.right != null) {
            childNode = tempNode.right;
        } else {
            //如果要删的点没有子节点，直接将它父节点指向它的指针置为null
            childNode = null;
        }
        //如果删除的点是根节点的情况
        if (fatherNode == null) {
            tree = childNode;
        } else if (fatherNode.left == tempNode) {
            fatherNode.left = childNode;
        } else {
            fatherNode.right = childNode;
        }
    }

}
