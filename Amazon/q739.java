// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/daily-temperatures/

// idea: https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack
// use stack to store the "unsolved" indices, and once a larger temperature comes, remove the indices from stack,
// always push a new temperature index into stack as the latest one is certainly "unsolved" for now'
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] answer = new int [temperatures.length];
        Stack<Integer> stack = new Stack<> ();
        for (int i=0; i<temperatures.length; i++) {
            // stack only contains "unsolved" indices
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i); // the current one (as the last one) is certainly unsolved for now
        }
        return answer;
        
        /* TLE
        HashSet<Integer> zero_idx = new HashSet<> ();
        int min = Integer.MAX_VALUE;
        for (int i=0; i<temperatures.length-1; i++) {
            if (temperatures[i+1]>temperatures[i]) {
                answer[i] = 1;
            } else {
                zero_idx.add(i);
                min = Math.min(min, temperatures[i]);
            }
            
            if (temperatures[i+1]>min) {
                Iterator<Integer> iterator = zero_idx.iterator();
                while (iterator.hasNext()) {
                    Integer possible_idx = iterator.next();
                    if (temperatures[possible_idx]<temperatures[i+1]) {
                        answer[possible_idx] = i+1-possible_idx;
                        iterator.remove();
                    }
                }
            }
        }
        return answer;*/
    }
}