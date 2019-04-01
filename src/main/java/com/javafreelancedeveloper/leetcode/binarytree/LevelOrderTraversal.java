package com.javafreelancedeveloper.leetcode.binarytree;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Level Order Traversal: breadth first
 */
public class LevelOrderTraversal {

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
        LevelOrderTraversal sandbox = new LevelOrderTraversal();
        List<List<Integer>> result = sandbox.levelOrder(root);
        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5));
        assertEquals(expectedResult, result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root);
        return result;
    }

    private void traverse(List<List<Integer>> result, TreeNode root) {

        if (root != null) {
            Queue<LevelTreeNode> queue = new LinkedList<>();
            queue.add(new LevelTreeNode(1, root));
            Integer lastLevel = 0;
            while (!queue.isEmpty()) {

                LevelTreeNode node = queue.poll();

                boolean newLevel = lastLevel==0 || !node.level.equals(lastLevel);

                List<Integer> levelList;
                if (newLevel) {
                    levelList = new ArrayList<>();
                    result.add(levelList);
                } else {
                    levelList = result.get(result.size() - 1);
                }

                levelList.add(node.treeNode.val);

                if (node.treeNode.left != null) {
                    queue.add(new LevelTreeNode(node.level+1, node.treeNode.left));
                }

                if (node.treeNode.right != null) {
                    queue.add(new LevelTreeNode(node.level+1, node.treeNode.right));
                }

                lastLevel = node.level;
            }
        }

    }

    private class LevelTreeNode {
        Integer level;
        TreeNode treeNode;
        LevelTreeNode(int l, TreeNode tn) {
            level = l; treeNode = tn;
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
