// 2022.10.02
// Problem Statement:
// https://leetcode.com/problems/insert-delete-getrandom-o1/

// idea: use hashmap to search for existance and list for indexing
class RandomizedSet {
    private HashMap<Integer, Integer> ht;
    private List<Integer> l;
    public RandomizedSet() {
        ht = new HashMap<> ();
        l = new ArrayList<> ();
    }
    
    public boolean insert(int val) {
        // if exists do nothing
        // if not exists, add to the end
        if (ht.containsKey(val)) {
            return false;
        }
        l.add(val);
        ht.put(val, l.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        // if not exists do nothing
        // if exists, substitute the one to remove with the last one
        if (!ht.containsKey(val)) {
            return false;
        }
        if (l.size()>1) {
            int idx = ht.get(val);
            if (idx == l.size()-1) {
                ht.remove(val);
                l.remove(idx);
                System.out.println(l);
            } else {
                int last = l.get(l.size()-1);
                l.set(idx, last);
                l.remove(l.size()-1);
                ht.remove(val);
                ht.put(last, idx);
            }
        } else {
            ht.remove(val);
            l = new ArrayList<> ();
        }
        return true;
    }
    
    public int getRandom() {
        // get a random number as index and get l[idx] in ArrayList
        int rand = (int) (l.size()*Math.random());
        return l.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */