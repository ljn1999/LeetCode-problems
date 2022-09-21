// 2022.09.21
// Problem Statement:
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // let n2 exceed n1 by n nodes, and when n2 reaches the last node, 
        // n1 points to the node previous to the node_to_remove
        if (head.next==null && n==1) return null;
        ListNode dummy = new ListNode ();
        dummy.next = head;
        ListNode n1 = dummy;
        ListNode n2 = dummy;
        for (int i=0; i<n; i++) {
            n2 = n2.next;
        }
        
        while (n2!=null && n2.next!=null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        
        ListNode n3 = null;
        if (n1!=null && n1.next!=null) n3 = n1.next.next;
        n1.next = n3;
        return dummy.next;
    }
}