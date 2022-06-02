// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/swap-nodes-in-pairs/

// idea: 3 pointers, first node & second node in a pair and the previous node
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
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode first=head, second=head.next;
        ListNode answer=head.next, prev=null;
        while (second!=null) {
            // reconnect
            first.next = second.next;
            second.next = first;
            if (prev!=null) {
                prev.next = second;
            }
            // move first, second and prev
            prev = first;
            first = first.next;
            if (first!=null) {
                second = first.next;
            } else {
                second = null;
            }
        }
        return answer;
    }
}