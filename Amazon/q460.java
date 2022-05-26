// 2022.05.26
// Problem Statement:
// https://leetcode.com/problems/lfu-cache/

// idea: use 3 hashmaps (one of them with linked hashset) to store key-value, key-count, and count-keys_list pairs
// the use of linked hashset can save us from iterating along the entire list for searching for a key
// https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet
class LFUCache {
    HashMap<Integer, Integer> vals; // key - value
    HashMap<Integer, Integer> counts; // key - count
    HashMap<Integer, LinkedHashSet<Integer>> lists; // count - keys that have this count
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        vals = new HashMap<> ();
        counts = new HashMap<> ();
        lists = new HashMap<> ();
        lists.put(1, new LinkedHashSet<Integer> ());
        cap = capacity;
    }
    
    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        // modify count and move its position in the list
        int cnt = counts.get(key);
        counts.put(key, cnt+1);
        lists.get(cnt).remove(key);
        if (!lists.containsKey(cnt+1)) {
            lists.put(cnt+1, new LinkedHashSet<Integer> ());
            lists.get(cnt+1).add(key);
        } else {
            lists.get(cnt+1).add(key);
        }
        // modify min if the accessed key had min as count 
        // and no other keys have the same count
        if (cnt==min && lists.get(cnt).size()==0) {
            min++;
        }
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (cap<=0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            int ret = get(key); // let get function do the modification work
            return;
        } else {
            if (vals.size()<cap) { // direct insert
                vals.put(key, value);
                counts.put(key, 1);
                if (!lists.containsKey(1)) {
                    lists.put(1, new LinkedHashSet<Integer> ());
                }
                lists.get(1).add(key);
                min = 1;
            } else { // have to remove one from the list
                int to_remove = lists.get(min).iterator().next();
                lists.get(min).remove(to_remove);
                min = 1;
                vals.remove(to_remove);
                counts.remove(to_remove);
                vals.put(key, value);
                counts.put(key, 1);
                if (!lists.containsKey(1)) {
                    lists.put(1, new LinkedHashSet<Integer> ());
                }
                lists.get(1).add(key);
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */