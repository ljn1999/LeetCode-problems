// 2022.06.16
// Problem Statement:
// https://leetcode.com/problems/add-two-numbers-ii/

// idea: use stack to store digits, and pop from the stack to get the correct order
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
        Stack<Integer> s1 = new Stack<> ();
        Stack<Integer> s2 = new Stack<> ();
        while (l1!=null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        ListNode curr_head = null;
        int carry_on = 0;
        while (s1.size()!=0 || s2.size()!=0) {
            int num1=0, num2=0;
            if (s1.size()!=0) num1 = s1.pop();
            if (s2.size()!=0) num2 = s2.pop();
            
            ListNode new_node = new ListNode((carry_on+num1+num2)%10);
            carry_on = (carry_on+num1+num2) >= 10 ? 1:0;
            // connect new_node with previous head
            new_node.next = curr_head;
            curr_head = new_node;
        }
        // deal with the msb if the final carry_on is 1
        if (carry_on != 0) {
            ListNode new_node = new ListNode(1);
            new_node.next = curr_head;
            curr_head = new_node;
        }
        return curr_head;
    }
}