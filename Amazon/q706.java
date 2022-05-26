// 2022.05.26
// Problem Statement:
// https://leetcode.com/problems/design-hashmap/

// idea: list of head nodes, build linked list to avoid collision
class MyHashMap {
    class Node {
        int key, val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    int hash_size = 13001; // a prime number >= 10*4 * 1.3
    Node [] ht;
    
    public MyHashMap() {
        ht = new Node [hash_size];
    }
    
    public void put(int key, int value) {
        int idx = key%hash_size;
        if (ht[idx]==null) {
            Node new_node = new Node(key, value);
            ht[idx] = new_node;
            return;
        } else {
            Node curr = ht[idx];
            while (curr.next!=null) {
                if (curr.key==key) {
                    curr.val = value;
                    return;
                }
                curr = curr.next;
            }
            if (curr.key==key) {
                curr.val = value;
                return;
            }
            curr.next = new Node(key, value);
            return;
        }
        
    }
    
    public int get(int key) {
        int idx = key%hash_size;
        if (ht[idx]==null) {
            return -1;
        } else {
            Node curr = ht[idx];
            while (curr!=null) {
                if (curr.key==key) {
                    return curr.val;
                }
                curr = curr.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        int idx = key%hash_size;
        if (ht[idx]==null) return;
        Node curr = ht[idx];
        Node prev = ht[idx];
        if (curr.key==key) { // remove the head
            ht[idx] = curr.next;
            curr.next = null;
            return;
        } else {
            while (curr!=null && curr.key!=key) {
                prev = curr;
                curr = curr.next;
            }
            if (curr==null) return;
            prev.next = curr.next;
            curr.next = null;
            return;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */