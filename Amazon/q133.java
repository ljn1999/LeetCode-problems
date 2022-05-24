// 2022.05.23
// Problem Statement:
// https://leetcode.com/problems/clone-graph/

// idea: bfs, push the origial node and the copied node into the same stack,
// and store all the copied nodes into the copies array.
// for each node, connect itself with its neighbors (build new if not constructed yet),
// and push the neighbors to the stack if not already on the stack
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        
        Stack<Node> stack = new Stack<> ();
        stack.add(node);
        Node new_node = new Node(node.val, new ArrayList<Node> ());
        stack.add(new_node);
        
        Node [] copies = new Node [101]; // constraint, val from 1-100
        copies[node.val] = new_node;
        HashSet<Integer> visited = new HashSet<> ();
        boolean first_time = true;
        Node ret = null;
        
        while (!stack.isEmpty()) {
            new_node = stack.pop();
            Node to_clone = stack.pop();
            if (first_time) {
                first_time = false;
                ret = new_node;
            }
            // connect new_node with all its neighbors
            for (Node n : to_clone.neighbors) {
                if (!visited.contains(n.val)) {
                    Node new_node_2 = null;
                    if (copies[n.val]==null) { // not constructed yet
                        new_node_2 = new Node(n.val, new ArrayList<Node> ());
                        copies[n.val] = new_node_2;
                    } else { // already built
                        new_node_2 = copies[n.val];
                    }
                    new_node.neighbors.add(new_node_2);
                    new_node_2.neighbors.add(new_node);
                    
                    if (!stack.contains(n)) {
                        stack.add(n);
                        stack.add(new_node_2);
                    } 
                }
            }
            visited.add(to_clone.val);
        }
        return ret;
    }
}