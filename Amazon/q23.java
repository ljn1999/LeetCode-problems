// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/merge-k-sorted-lists/

// idea: direct merging K lists, each time find the min among all heads, attach the answer's tail to the min,
// detach the min from the linked list, and move its head forward
// can check this faster recursive solution (based on merging 2 sorted lists):
// https://leetcode.com/problems/merge-k-sorted-lists/discuss/10522/My-simple-java-Solution-use-recursion
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
    public ListNode curr_min = null;
    public int curr_min_list_idx;
    public ListNode head = null;
    public ListNode tail = null;
    public boolean first_time;
    public boolean done;
    public int count = 0;
    
    public void mergeKListsHelper(ListNode[] lists) {
        first_time = true;
        done = true;
        for (int i=0; i<lists.length; i++) {
            if (lists[i]==null) {
            } else {
                done = false;
                if (first_time) {
                    curr_min = lists[i];
                    curr_min_list_idx = i;
                    first_time = false;
                } else if (lists[i].val<curr_min.val) {
                    curr_min = lists[i];
                    curr_min_list_idx = i;
                } 
            }
        }
        if (done) return;
        lists[curr_min_list_idx] = lists[curr_min_list_idx].next;
        if (head==null && tail==null) {
            head = curr_min;
            tail = curr_min;
        }
        tail.next = curr_min;
        curr_min.next = null;
        tail = curr_min;
        count++;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0 || (lists.length==1 && lists[0]==null)) return null;
        while (!done) {
            mergeKListsHelper(lists);
        }
        return head;
    }
}