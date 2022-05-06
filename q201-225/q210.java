// 2022.05.06
// Problem Statement:
// https://leetcode.com/problems/course-schedule-ii/

// idea: https://leetcode.com/problems/course-schedule-ii/discuss/190393/Topological-Sort-Template-General-Approach!!
// typical topological sort problem, this template can be useful.
// build 2 maps (about parent-children relationship and in-arrows degree)
// in a loop add the nodes without in-arrows into the answer list (all prerequisites are met)
// after adding into answer list, remove it from in_degree map, decrease number of in-arrows in their children
// if not a single non-in-arrow nodes can be found -> exists a circle in the graph -> return empty list
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // put in hashtable to save traverse time
        Map <Integer, List<Integer>> ht = new HashMap <Integer, List<Integer>>();
        Map <Integer, Integer> in_degree = new HashMap <Integer, Integer>();
        
        for(int i = 0; i < numCourses; i++) {
            in_degree.put(i, 0);
        }
        
        for (int i=0; i<prerequisites.length; i++) {
            if (ht.containsKey(prerequisites[i][1])) {
                List<Integer> temp = ht.get(prerequisites[i][1]);
                temp.add(prerequisites[i][0]);
                ht.put(prerequisites[i][1], temp);
            } else {
                List<Integer> new_list = new ArrayList<Integer> ();
                new_list.add(prerequisites[i][0]);
                ht.put(prerequisites[i][1], new_list);
            }
            if (in_degree.containsKey(prerequisites[i][0])) {
                in_degree.put(prerequisites[i][0], in_degree.get(prerequisites[i][0])+1);
            } else {
                in_degree.put(prerequisites[i][0], 1);
            }
        }
        
        int [] answer = new int [numCourses];
        int count = 0;
        while (!in_degree.isEmpty()) {
            boolean no_cycle = false;
            for (int course : in_degree.keySet()) {
                if (in_degree.get(course) == 0) {
                    answer[count] = course;
                    count++;
                    // decrease children's in_degree
                    if (ht.containsKey(course)) {
                        for (int i=0; i<ht.get(course).size(); i++) {
                            int child = ht.get(course).get(i);
                            in_degree.put(child, in_degree.get(child)-1);
                        }
                    }
                    in_degree.remove(course);
                    no_cycle = true;
                    break;
                }
            }
            if (!no_cycle) return new int [0];
        }
        return answer;
    }
}