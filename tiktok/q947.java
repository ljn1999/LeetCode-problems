// 2022.10.03
// Problem Statement:
// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

// idea: dfs, no need to be neighbours, as long as they are in the same row/col
// count number of islands and return stones number - islands count
// can also use union search but I couldn't understand the solution at all
class Solution {
    private int island;
    private void dfs(int[] i, int[][] stones, HashSet<int []>visited) {
        visited.add(i);
        for (int[] s : stones) {
            if (!visited.contains(s)) {
                if (i[0]==s[0] || i[1]==s[1]) {
                    dfs(s, stones, visited);
                }
            }
        }
        return;
    }
    public int removeStones(int[][] stones) {
        HashSet<int []> visited = new HashSet<> ();
        island = 0;
        // count island
        for (int i=0; i<stones.length; i++) {
            if (visited.contains(stones[i])) continue;
            dfs(stones[i], stones, visited);
            island++;
        }
        return stones.length-island;
    }

    /*
    Iterator<Integer> it_int = ht.keySet().iterator();
    while (it_int.hasNext()) {
        int i=it_int.next();
    }

    Iterator<Map.Entry<Integer, Integer>> it_map = ht.entrySet().iterator();
    while (it_map.hasNext()) {
        Map.Entry<Integer, Integer> i = it_int.next();
        i.getVal();
        i.getKey();
    }
    */
}

