package com.javafreelancedeveloper.leetcode.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Use in-order traversal to validate a binary search tree!
 */
public class ValidateBinarySearchTree {

    @Test
    public void testIt1() {
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(true, result);
    }

    @Test
    public void testIt2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6))
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(false, result);
    }

    @Test
    public void testIt3() {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(6,
                        new TreeNode(7),
                        new TreeNode(3))
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(false, result);
    }

    @Test
    public void testIt4() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7))
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(false, result);
    }

    @Test
    public void testIt5() {
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,
                                null,
                                new TreeNode(3))),
                new TreeNode(5,
                        new TreeNode(4),
                        new TreeNode(6))
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(false, result);
    }


    @Test
    public void testIt6() {
        TreeNode root = new TreeNode(10,
                new TreeNode(5),
                new TreeNode(15,
                        new TreeNode(14),
                        new TreeNode(16))
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(true, result);
    }


    @Test
    public void testIt7() {
        TreeNode root = new TreeNode(3,
                null,
                new TreeNode(30,
                        new TreeNode(10,
                                null,
                                new TreeNode(15,
                                        null,
                                        new TreeNode(45))),
                        null)
        );
        ValidateBinarySearchTree sandbox = new ValidateBinarySearchTree();
        boolean result = sandbox.isValidBST(root);
        assertEquals(false, result);
    }


    public boolean isValidBST(TreeNode root) {
        List<Integer> orderedList = new ArrayList<>();
        return thing(orderedList, root);
    }

    private boolean thing(List<Integer> orderedList, TreeNode node) {
        if (node != null) {
            boolean leftValid;
            if (node.left == null) {
                leftValid = true;
            } else {
                leftValid = thing(orderedList, node.left);
            }
            if (!leftValid) {
                return false;
            }
            boolean thisValid = orderedList.isEmpty() || node.val > orderedList.get(orderedList.size() - 1);
            if (!thisValid) {
                return false;
            }
            orderedList.add(node.val);
            boolean rightValid;
            if (node.right == null) {
                rightValid = true;
            } else {
                rightValid = thing(orderedList, node.right);
            }
            return leftValid && thisValid && rightValid;
        } else {
            return true;
        }
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }
}
