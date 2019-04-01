package com.javafreelancedeveloper.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteNode {

    @Test
    public void testIt() {
        DeleteNode sandbox = new DeleteNode();
        ListNode nodeToDelete = new ListNode(1, new ListNode(9));
        ListNode input = new ListNode(4, new ListNode(5, nodeToDelete));
        ListNode expectedOutput = new ListNode(4, new ListNode(5, new ListNode(9)));
        sandbox.deleteNode(nodeToDelete);
        assertEquals(expectedOutput.toString(), input.toString());
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode ln) {
            val = x;
            next = ln;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
