// 2022.05.03
// Problem Statement:
// https://leetcode.com/problems/course-schedule/

// idea: dfs, find every path for each course. 
// Consider a course a leave if it has no prerequisites
// 1->2->3->4->5(leave) legal
// 1->2->3->4->1 illegal
// a course is legal if every of its prerequisites is legal
class Solution {
    public boolean dfs(int course, Map <Integer, List<Integer>> ht, List <Integer> path) {
        if (!ht.containsKey(course)) {
            if (path.get(path.size()-1) == course) {
                path.remove(path.size()-1);
            }
            return true; // no prerequisites
        }
        boolean legal = true;
        path.add(course);
        for (int i=0; i<ht.get(course).size(); i++) {
            if (path.contains(ht.get(course).get(i))) {
                return false;
            }
            legal = legal && dfs(ht.get(course).get(i), ht, path);
            if (!legal) return false;
        }
        if (legal) {
            List<Integer> new_list = new ArrayList<Integer> ();
            ht.put(course, new_list);
            if (path.get(path.size()-1) == course) {
                path.remove(path.size()-1);
            }
            return true;
        }
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length==0) return true;
        // put in hashtable to save traverse time
        Map <Integer, List<Integer>> ht = new HashMap <Integer, List<Integer>>();
        for (int i=0; i<prerequisites.length; i++) {
            if (ht.containsKey(prerequisites[i][0])) {
                List<Integer> temp = ht.get(prerequisites[i][0]);
                temp.add(prerequisites[i][1]);
                ht.put(prerequisites[i][0], temp);
            } else {
                List<Integer> new_list = new ArrayList<Integer> ();
                new_list.add(prerequisites[i][1]);
                ht.put(prerequisites[i][0], new_list);
            }
        }
        boolean answer = true;
        for (int i=0; i<numCourses; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            answer = answer && dfs(i, ht, path);
        }
        return answer;
    }
}