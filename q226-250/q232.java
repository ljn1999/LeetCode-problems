// 2022.05.11
// Problem Statement:
// https://leetcode.com/problems/implement-queue-using-stacks/

// idea: 3 stacks, one for output (s1), two for maintaining order (s2 & s3)
// a better one using only 2 stacks
// https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C%2B%2B-Java-Ruby
class MyQueue {
    public Stack<Integer> s1;
    public Stack<Integer> s2;
    public Stack<Integer> s3;
    
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        // push to the bottom of stack
        s2 = new Stack<Integer>();
        s3 = new Stack<Integer>();
        s3.push(x);
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        while (!s2.isEmpty()) {
            s3.push(s2.pop());
        }
        s1 = s3;
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return (s1.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */