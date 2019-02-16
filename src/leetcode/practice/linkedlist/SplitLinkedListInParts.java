/*
 * Copyright (c) 2019.  Gaurav Sharma, All rights reserved.
 */

package leetcode.practice.linkedlist;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {

        int length = 0;

        ListNode head = root;

        while (root != null) {
            length++;
            root = root.next;
        }

        int parts = length / k;
        int rem = length % k;

        ListNode[] listNodes = new ListNode[k];


        for (int currpart = 0; currpart < k; currpart++) {

            int partMaxLen = (rem <= 0) ? parts : parts + 1;
            rem--;

            ListNode currNode = null;
            ListNode currHead = null;


            for (int i = 1; i <= partMaxLen; i++) {
                if (currNode == null) {
                    currNode = (head == null) ? null : new ListNode(head.val);
                    currHead = currNode;
                } else {
                    currNode.next = (head == null) ? null : new ListNode(head.val);
                    currNode = currNode.next;
                }
                head = head.next;


            }

            listNodes[currpart] = currHead;

        }

        return listNodes;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode head = listNode1;

        for (int i = 2; i <= 7; i++) {
            listNode1.next = new ListNode(i);
            listNode1 = listNode1.next;
        }


        new SplitLinkedListInParts().splitListToParts(head, 3);


    }
}
