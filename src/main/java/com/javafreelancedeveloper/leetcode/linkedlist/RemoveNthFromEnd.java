package com.javafreelancedeveloper.leetcode.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class RemoveNthFromEnd {

    @Test
    public void testIt1() {
        RemoveNthFromEnd sandbox = new RemoveNthFromEnd();
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expectedOutput = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))));
        ListNode result = sandbox.removeNthFromEnd(input, 2);
        assertEquals(expectedOutput.toString(), result.toString());
    }


    @Test
    public void testIt2() {
        RemoveNthFromEnd sandbox = new RemoveNthFromEnd();
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expectedOutput = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        ListNode result = sandbox.removeNthFromEnd(input, 3);
        assertEquals(expectedOutput.toString(), result.toString());
    }


    @Test
    public void testIt3() {
        RemoveNthFromEnd sandbox = new RemoveNthFromEnd();
        ListNode input = new ListNode(1);
        ListNode result = sandbox.removeNthFromEnd(input, 1);
        assertNull(result);
    }

    @Test
    public void testIt4() {
        RemoveNthFromEnd sandbox = new RemoveNthFromEnd();
        ListNode input = new ListNode(1, new ListNode(2));
        ListNode expectedOutput = new ListNode(1);
        ListNode result = sandbox.removeNthFromEnd(input, 1);
        assertEquals(expectedOutput.toString(), result.toString());
    }

    @Test
    public void testIt5() {
        RemoveNthFromEnd sandbox = new RemoveNthFromEnd();
        ListNode input = new ListNode(1, new ListNode(2));
        ListNode expectedOutput = new ListNode(2);
        ListNode result = sandbox.removeNthFromEnd(input, 2);
        assertEquals(expectedOutput.toString(), result.toString());
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nfl = new ArrayList<>();
        nfl.add(head);
        ListNode endNode = head.next;
        while (endNode != null) {
            nfl.add(endNode);
            endNode = endNode.next;
        }
        int removeIndex = nfl.size() - n;
        ListNode nodeToRemove = nfl.get(removeIndex);
        if (removeIndex == 0) {
            return nodeToRemove.next;
        } else {
            ListNode nodeToPushInto = nfl.get(removeIndex - 1);
            nodeToPushInto.next = nodeToRemove.next;
            return head;
        }
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
