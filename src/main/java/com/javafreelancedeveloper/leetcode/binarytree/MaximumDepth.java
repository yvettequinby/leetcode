package com.javafreelancedeveloper.leetcode.binarytree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumDepth {

    @Test
    public void testIt() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        null)
        );
        MaximumDepth sandbox = new MaximumDepth();
        Integer result = sandbox.maxDepth(root);
        Integer expectedResult = 3;
        assertEquals(expectedResult, result);
    }

    public int maxDepth(TreeNode root) {
        return thing(0, root);

    }

    private int thing(int depth, TreeNode node) {
        if(node!=null) {
            int left = thing(depth+1, node.left);
            int right = thing(depth+1, node.right);
            return Math.max(left, right);
        } else {
            return depth;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode l, TreeNode r) { val = x; left=l; right = r;}
    }
}
