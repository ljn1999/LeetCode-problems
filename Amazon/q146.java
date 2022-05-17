// 2022.05.17
// Problem Statement:
// https://leetcode.com/problems/lru-cache/
// did it in 2021/03/23 in python

// idea: double linked list, otherwise TLE
// also have to keep head and tail together for faster add_to_tail operations
class LRUCache {
    public int cap;
    class DNode {
        int key;
        int value;
        DNode left;
        DNode right;
    }
    public DNode head;
    public DNode tail;
    public Map <Integer, DNode> ht;

    public void removeNode (DNode node) {
        DNode l_node = node.left;
        DNode r_node = node.right;
        if (l_node==null && r_node==null) {
            head = null;
            tail = null;
            return;
        } else if (l_node==null) {
            head = head.right;
            node.right = null;
            r_node.left = null;
            return;
        } else if (r_node==null) {
            tail = tail.left;
            l_node.right = null;
            node.left = null;
            return;
        } else {
            node.left = null;
            node.right = null;
            l_node.right = r_node;
            r_node.left = l_node;
            return;
        }
    }
    
    public void addNode (DNode node) {
        if (head==null) { // empty list
            head = node;
            tail = node;
            return;
        } else {
            tail.right = node;
            node.left = tail;
            tail = tail.right;
            return;
        }
    } 
    
    public LRUCache(int capacity) {
        cap = capacity;
        //list = new LinkedList<Integer> ();
        head = null;
        tail = null;
        ht = new HashMap <Integer, DNode> ();
    }
    
    public int get(int key) {
        if (ht.containsKey(key)) {
            removeNode(ht.get(key)); // remove from the middle
            addNode(ht.get(key)); // attach to the tail
            return ht.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (ht.containsKey(key)) {
            ht.get(key).value = value;
            ht.put(key, ht.get(key));
            removeNode(ht.get(key)); // remove from the middle
            addNode(ht.get(key)); // attach to the tail
        } else {
            if (ht.size()<cap) { // direct add
                DNode node = new DNode ();
                node.key = key;
                node.value = value;
                ht.put(key, node);
                addNode(node);
            } else { // have to remove the least recent used node
                DNode node = new DNode ();
                node.key = key;
                node.value = value;
                ht.put(key, node);
                ht.remove(head.key); // remove from ht
                removeNode(head); // remove from linked list
                addNode(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */