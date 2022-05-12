// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/palindrome-linked-list/

// idea: https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
// get to the second half and then reverse the second half and then compare
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
        if (head==null || head.next==null) return head;
        if (head.next.next == null) {
            ListNode next_node = head.next;
            head.next = null;
            next_node.next = head;
            return next_node;
        }
        ListNode rest_reversed_head = reverseList(head.next);
        ListNode curr = head.next;
        curr.next = head;
        head.next = null;
        return rest_reversed_head;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head.next==null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        // slow is the start of the second half
        // reverse the second half
        ListNode second_half = reverseList(slow);
        while (second_half!=null && head!=null) {
            if (second_half.val!=head.val) return false;
            second_half = second_half.next;
            head = head.next;
        }
        return true;
        //if (fast==null) // even
    }
}