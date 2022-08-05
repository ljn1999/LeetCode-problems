// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

// idea: go to second half of linkedlist, reverse the second half recursively (O(N)), 
// get the max pair of the sum
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
    public ListNode reverse_list(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode reverse_head = reverse_list(head.next);
        head.next.next = head;
        head.next = null;
        return reverse_head;
    }
    
    public int pairSum(ListNode head) {
        // get to the second half
        ListNode slow=head, fast=head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of linked list O(N)
        ListNode second_half = reverse_list(slow);

        // get the max pair sum
        int answer = (-1)*Integer.MAX_VALUE;
        while (second_half!=null) {
            answer = Math.max(answer, second_half.val + head.val);
            head = head.next;
            second_half = second_half.next;
        }
        return answer;
    }
}