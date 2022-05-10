// 2022.05.10
// Problem Statement:
// https://leetcode.com/problems/implement-stack-using-queues/

// idea: when doing push, push to the front (not the tail) of the queue,
// with that push, the pop() and top() can be normal, as in the queue new value goes before old value
// can use just 1 queue instead of 2
class MyStack {
    public Queue<Integer> q1;
    public Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        // add to the front of the queue
        q2 = new LinkedList<Integer>();
        q2.add(x);
        while (q1.size()>0) {
            q2.add(q1.poll());
        }
        q1 = q2;
    }
    
    public int pop() {
        // return the front of the queue and remove it
        return q1.poll();
    }
    
    public int top() {
        // return the front of the queue
        return q1.peek();
    }
    
    public boolean empty() {
        return (q1.size()==0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */