// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/delete-node-in-a-linked-list/

// idea: move the val of the next node to the previous node, until reach the end
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        ListNode next = node.next;
        while (next.next!=null) {
            prev.val = next.val;
            prev = prev.next;
            next = next.next;
        }
        prev.val = next.val;
        prev.next = null;
        return;
    }
}