// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/reorder-list/

// idea: seperate to 2 half, reverse the second half and merge with the first half
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
    public void reverseList(ListNode head) {
        if (head==null) return;
        if (head.next==null) return;
        ListNode next_node = head.next;
        reverseList(next_node);
        next_node.next = head;
        head.next = null;
        return;
    }

    public void reorderList(ListNode head) {
        // reverse and merge
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second_half = slow.next;
        while (fast.next!=null) {
            fast = fast.next;
        }
        // now fast is the new head to merge
        slow.next = null;
        reverseList(second_half);
        
        // merge head and fast
        ListNode first=head, second=fast;
        ListNode first_next=null, second_next=null;
        while (second!=null) {
            first_next = first.next;
            second_next = second.next;
            first.next = second;
            second.next = first_next;
            first = first_next;
            second = second_next;
        }
        return;
    }
}