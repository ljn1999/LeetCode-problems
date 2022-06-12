// 2022.06.12
// Problem Statement:
// https://leetcode.com/problems/reverse-linked-list-ii/

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

 // idea: disconnect the middle part and reverse, then reconnect
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode next = head.next;
        head.next = null; // disconnect head
        ListNode ret_head = reverseList(next);
        next.next = head;
        return ret_head;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first_tail = dummy, last_head = head;
        ListNode left_node = dummy, right_node = head;
        int cnt = 1;
        // locate left_node, right_node, first_tail and last_head
        while (cnt<left) {
            first_tail = first_tail.next;
            left_node = left_node.next;
            last_head = last_head.next;
            right_node = right_node.next;
            cnt++;
        }
        left_node = left_node.next; // move left_node forward
        first_tail.next = null;
        
        while (cnt<right) {
            last_head = last_head.next;
            right_node = right_node.next;
            cnt++;
        }
        last_head = last_head.next; // move last_head forward
        right_node.next = null;
        
        // reverse the middle part and reconnect
        ListNode temp = reverseList(left_node);
        first_tail.next = right_node;
        left_node.next = last_head;
        return dummy.next;
    }
}