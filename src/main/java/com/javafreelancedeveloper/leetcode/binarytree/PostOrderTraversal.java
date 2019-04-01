package com.javafreelancedeveloper.leetcode.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Post Order Traversal: Left, Right, Root
 */
public class PostOrderTraversal {

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
        PostOrderTraversal sandbox = new PostOrderTraversal();
        List<Integer> result = sandbox.postOrderTraversal(root);
        List<Integer> expectedResult = Arrays.asList(4, 5, 2, 3, 1);
        assertEquals(expectedResult, result);
    }


    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        thing(result, root);
        return result;
    }


    private void thing(List<Integer> orderedList, TreeNode node) {
        if(node!=null) {
            if(node.left!=null) {
                thing(orderedList, node.left);
            }
            if(node.right!=null) {
                thing(orderedList, node.right);
            }
            orderedList.add(node.val);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x,TreeNode l, TreeNode r) { val = x; left=l; right = r;}
    }
}
