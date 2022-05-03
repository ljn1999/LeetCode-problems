// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/reverse-linked-list/

// idea: recursive method
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // base case 1
        if (head==null || head.next==null) return head;
        // base case 2
        if (head.next.next == null) {
            ListNode next_node = head.next;
            head.next = null;
            next_node.next = head;
            return next_node;
        }
        // recursive call, reverse the rest and attach the head to the tail of the reversed list
        ListNode rest_reversed_head = reverseList(head.next);
        // the tail of the reversed list = head.next
        ListNode curr = head.next;
        curr.next = head;
        head.next = null;
        return rest_reversed_head;
    }
}