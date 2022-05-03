// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/remove-linked-list-elements/

// idea: first get the start node, then do normal removal
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
    public ListNode removeElements(ListNode head, int val) {
        if (head==null || val==0) return head;
        ListNode answer_head = head;
        while (answer_head!=null && answer_head.val==val) {
            answer_head = answer_head.next;
        }
        if (answer_head==null) return answer_head;
        ListNode curr = answer_head.next;
        ListNode prev = answer_head;
        while (curr!=null) {
            if (curr.val!=val) {
                curr = curr.next;
                prev = prev.next;
            } else {
                curr = curr.next;
                prev.next = curr;
            }
        }
        return answer_head;
    }
}