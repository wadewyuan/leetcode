package com.leetcode.medium;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author wadey
 *
 */

public class AddTwoNumbers {

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* Regular Solution */
        int sum = 0;
        boolean nextIncrement = false;
        SinglyLinkedList l = new SinglyLinkedList();
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null || n2 != null) {
            sum = (n1 != null ? n1.val : 0) + (n2 != null ? n2.val : 0);
            if(nextIncrement) {
                sum++;
            }
            nextIncrement = sum >= 10;

            n1 = n1 != null ? n1.next : null;
            n2 = n2 != null ? n2.next : null;
            l.add(nextIncrement ? sum-10 : sum);
        }

        if(nextIncrement) {
            l.add(1);
        }

        return l.head;

        /* Recursion */
//        if(l1 == null && l2 == null) {
//            return null;
//        }
//        if(l1 == null) {
//            return l2;
//        }else if(l2 == null) {
//            return l1;
//        }
//        l1.val = l1.val + l2.val;
//        l1.next = addTwoNumbers(l1.next, l2.next);
//        if(l1.val >= 10) {
//            l1.val -= 10;
//            if(l1.next != null) {
//                l1.next.val++;
//                if(l1.next.val >= 10) {
//                    l1.next.val -= 10;
//                    l1.next.next = new ListNode(1);
//                }
//            } else {
//                l1.next = new ListNode(1);
//            }
//        }
//
//        return l1;
    }

    static SinglyLinkedList createLinkedListFromNumber(int num) {
        SinglyLinkedList l = new SinglyLinkedList();
        String s = String.valueOf(num);
        char[] numChars = s.toCharArray();
        for(int i = numChars.length - 1; i >= 0; i--) {
            l.add(Integer.parseInt(String.valueOf(numChars[i])));
        }

        return l;
    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedListFromNumber(99999999).head;
        ListNode l2 = createLinkedListFromNumber(1).head;
        System.out.println(l1);
        System.out.println(l2);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}

class SinglyLinkedList {
    ListNode head;
    ListNode tail;

    void add(int n) {
        ListNode node = new ListNode(n);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        String s = String.valueOf(this.val);
        ListNode nexNode = this.next;
        while (nexNode != null) {
            s += "->" + nexNode.val;
            nexNode = nexNode.next;
        }
        return s;
    }
}