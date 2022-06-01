// 2022.05.31
// Problem Statement:
// https://leetcode.com/problems/partition-list/

// idea: partition to 2 lists, first list contains all nodes smaller than x, 
// second list contains all nodes greater or equal to x.
// finally attach the tail of the first list to the second list
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
    public ListNode partition(ListNode head, int x) {
        if (head==null) return null;
        boolean found_first_head=false, found_second_head=false;
        ListNode first_head=null, first_tail=null, second_head=null, second_tail=null;
        ListNode curr = head, ptr=null;
        while (curr!=null) {
            if (curr.val<x) {
                if (!found_first_head) { // initialize first_head and first_tail
                    first_head = curr;
                    first_tail = curr;
                    found_first_head = true;
                    if (head!=curr) { // detach curr
                        second_tail.next = curr.next;
                    }
                    ptr = curr;
                    curr = curr.next;
                    ptr.next = null;
                } else {
                    // detach curr
                    if (second_tail!=null) { // previous node is second_tail
                        second_tail.next = curr.next;
                    }
                    ptr = curr;
                    curr = curr.next;
                    ptr.next = null;
                    // attach to first_tail, update first_tail
                    first_tail.next = ptr;
                    first_tail = ptr;
                }
            } else { // no need to detach and attach
                if (!found_second_head) { // initialize second_head and second_tail
                    second_head = curr;
                    second_tail = curr;
                    found_second_head = true;
                }
                second_tail = curr; // update second_tail
                curr = curr.next;
            }
        }
        // link 2 lists together
        if (first_tail!=null) {
            first_tail.next = second_head;
            return first_head;
        } else {
            return second_head;
        }
        
    }
}