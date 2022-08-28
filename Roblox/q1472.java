// 2022.08.28
// Problem Statement:
// https://leetcode.com/problems/design-browser-history/

// idea: use an arraylist to record the browse history, use pos to track the current position in the list
class BrowserHistory {
    public int pos;
    public List<String> history;
    
    public BrowserHistory(String homepage) {
        history = new ArrayList<String> ();
        history.add(homepage);
        pos = 0;
    }
    
    public void visit(String url) {
        // empty the forward history
        while (history.size()>pos+1) {
            history.remove(pos+1);
        }
        history.add(url);
        pos = history.size()-1;
    }
    
    public String back(int steps) {
        int actual_steps = Math.min(pos, steps);
        pos = pos-actual_steps;
        return history.get(pos);
    }
    
    public String forward(int steps) {
        int actual_steps = Math.min(history.size()-1-pos, steps);
        pos = pos+actual_steps;
        return history.get(pos);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */