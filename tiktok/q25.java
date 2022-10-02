// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/reverse-nodes-in-k-group/

// idea: seperate to n/k groups and do reverseFirstK for each group,
// everytime move head to reverseFirstK forward by k (old head's next)
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
    public ListNode reverseFirstK(ListNode head, int k) {
        // ex: 1 2 3 4 5, k=4
        // after first recursion get: 1 4 3 2 5
        // want to get: 4 3 2 1 5
        if (k==1) return head;
        ListNode new_tail = head.next; // 2
        ListNode new_head = reverseFirstK(head.next, k-1); // 4
        ListNode temp = new_tail.next;
        new_tail.next = head;
        head.next = temp;
        return new_head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // ex: 1 2 3 4 5 6 7, k=2, curr=1
        // after first function call: 2 1 3 4 5 6 7, new curr=curr->next=3,
        // do reverse starting from 3 to 4, return new head 4, connect with 1 (old current)
        int length = 0;
        ListNode curr = head;
        while (curr!=null) {
            curr = curr.next;
            length++;
        }
        int time = length/k;
        curr = head;
        ListNode prev = curr;
        ListNode ret_head = null;
        for (int i=0; i<time; i++) {
            ListNode temp = reverseFirstK(curr, k);
            if (i!=0) { // connect with the previous part
                prev.next = temp;
            } else { // get the return head
                ret_head = temp;
            }
            // update prev to old curr and move curr forward
            prev = curr;
            curr = curr.next;
        }
        return ret_head;
    }
}