package org.lgt.datastruct.tree;

public class BinaryTreeTraversal {
    private TreeNode head;
    public BinaryTreeTraversal(TreeNode head) {
        this.head = head;
    }

    public void preOrderRecur(TreeNode node) {
        if(head == null) {
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(TreeNode node) {
        if(head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    public void postOrderRecur(TreeNode node) {
        if(head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value);
    }
}
