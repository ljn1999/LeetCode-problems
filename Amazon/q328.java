// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/odd-even-linked-list/

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
// idea: multiple pointers
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode first = head, second = head.next;
        ListNode even_head = second, even_tail = null, odd_tail = null;
        while (second!=null) {
            if (odd_tail==null) { // the beginning of the list
                // update odd_tail and even_tail
                odd_tail = head;
                even_tail = head.next;
            } else { // the middle of the list
                // attach first and second to the odd and even lists
                odd_tail.next = first;
                even_tail.next = second;
                // update odd_tail and even_tail
                odd_tail = odd_tail.next;
                even_tail = even_tail.next;
            }
            // update first and second
            first = first.next.next;
            if (second.next!=null) {
                second = second.next.next;
            } else {
                break;
            }
            // detach the 2 tails
            odd_tail.next = null;
            even_tail.next = null;
        }
        // connect odd and even lists together
        if (first!=null) { // need to attach the last odd element for odd-number linkedlists
        odd_tail.next = first;
        odd_tail = odd_tail.next;
        }
        odd_tail.next = even_head;
        return head;
    }
}