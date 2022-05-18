// 2022.05.18
// Problem Statement:
// https://leetcode.com/problems/min-stack/

// idea: build 2 stacks to track the number and the min value so far
class MinStack {
    public Stack<Integer> stack;
    public int min;
    public Stack<Integer> min_stack;
    public MinStack() {
        stack  = new Stack<Integer> ();
        min_stack  = new Stack<Integer> ();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);
        min_stack.push(min);
    }
    
    public void pop() {
        int temp = stack.pop();
        min_stack.pop();
        if (temp==min) {
            if (!min_stack.isEmpty()) {
                min = min_stack.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */