// 2022.05.18 midnight
// Problem Statement:
// https://leetcode.com/problems/add-two-numbers/

// idea: use add_on to check if the sum is over 10, add an extra 1 to the tail if there's a last add_on
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add_on = 0;
        int num1, num2;
        ListNode head = null;
        ListNode curr = null;
        boolean first_time = true;
        while (!(l1==null && l2==null)) {
            if (l1==null) {
                num1 = 0;
            } else {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2==null) {
                num2 = 0;
            } else {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = (num1+num2+add_on)%10;
            add_on = (num1+num2+add_on)/10;
            ListNode new_node = new ListNode(sum);
            if (first_time) {
                first_time = false;
                head = new_node;
                curr = head;
            } else {
                curr.next = new_node;
                curr = curr.next;
            }
        }
        if (add_on!=0) {
            ListNode new_node = new ListNode(1);
            curr.next = new_node;
        }
        return head;
    }
}