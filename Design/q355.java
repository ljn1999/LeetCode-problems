// 2022.10.24
// Problem Statement:
// https://leetcode.com/problems/design-twitter/

// idea: multiple hashmaps, priority queue to sort in get feed
class Twitter {
    // tweet id -- post time
    // user id -- list of its followees
    // user id -- list of post ids
    HashMap<Integer, Integer> id_time; // key is post id, value is user id
    HashMap<Integer, List<Integer>> id_follow; // key is following value list
    HashMap<Integer, List<Integer>> id_posts;
    private int time;
    public Twitter() {
        id_time = new HashMap<> ();
        id_follow = new HashMap<> ();
        id_posts = new HashMap<> ();
        id_feed = new HashMap<> ();
        time = 0;
        return;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        id_time.put(tweetId, time);
        id_posts.putIfAbsent(userId, new ArrayList<> ());
        id_posts.get(userId).add(tweetId);
        return;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>> (
        new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue()>e2.getValue()) return -1;
                else if (e1.getValue()==e2.getValue()) return 0;
                else return 1;
            } 
        });
        
        if (id_posts.containsKey(userId)) {
            for (int i : id_posts.get(userId)) {
                Map.Entry<Integer, Integer> m = Map.entry(i, id_time.get(i));
                q.offer(m);
            }
        }
        
        if (id_follow.containsKey(userId)) {
            for (int f : id_follow.get(userId)) {
                if (id_posts.containsKey(f)) {
                    for (int i : id_posts.get(f)) {
                        Map.Entry<Integer, Integer> m = Map.entry(i, id_time.get(i));
                        q.offer(m);
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<> ();
        while (res.size()<10 && q.size()>0) {
            if (!res.contains(q.peek().getKey())) res.add(q.peek().getKey());
            q.poll();
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        id_follow.putIfAbsent(followerId, new ArrayList<> ());
        id_follow.get(followerId).add(followeeId);
        return;
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (id_follow.containsKey(followerId)) {
            for (int i=0; i<id_follow.get(followerId).size(); i++) {
                if (id_follow.get(followerId).get(i)==followeeId) {
                    id_follow.get(followerId).remove(i);
                    break;
                }
            }
        }
        return;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */