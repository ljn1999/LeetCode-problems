// 2022.08.31
// Problem Statement:
// https://leetcode.com/problems/evaluate-division/

// idea: build a directional graph, record relations btw both 2 points,
// then search with dfs, use visited hashset to avoid circles,
// and use -1 to denote no rational value
class Solution {
    public Map<String, Map<String, Double>> graph;
    
    public double calcSingleEquation(String first, String second, Set<String> visited) {
        // search with dfs
        // base case
        if (!graph.containsKey(first)) return -1.0; // do not exist in graph
        if (graph.get(first).containsKey(second)) { // direct return
            return graph.get(first).get(second);
        }
        
        visited.add(first);
        for (Map.Entry<String, Double> neighbor : graph.get(first).entrySet()) { // search all its neighbors
            if (!visited.contains(neighbor.getKey())) {
                double rest = calcSingleEquation(neighbor.getKey(), second, visited);
                if (rest==-1) continue; // search the next neighbor point
                else return rest * neighbor.getValue();
            }
        }
        // no neighbor can get a valid result, return -1
        return -1;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build the graph
        graph = new HashMap<> ();
        for (int i=0; i<equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            graph.putIfAbsent(first, new HashMap<> ());
            graph.putIfAbsent(second, new HashMap<> ());
            graph.get(first).put(second, values[i]);
            graph.get(second).put(first, 1/values[i]);
        }
        
        // use dfs to search
        double [] answer = new double [queries.size()];
        for (int i=0; i<queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            answer[i] = calcSingleEquation(first, second, new HashSet<String> ());
        }
        return answer;
    }
}