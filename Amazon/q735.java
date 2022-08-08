// 2022.08.08
// Problem Statement:
// https://leetcode.com/problems/asteroid-collision/

// idea: for each new asteroid, check if a collision could happen,
// if not, add into the list directly, otherwise collise until no further collision could happen
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> a_l = new ArrayList<> ();
        for (int i=0; i<asteroids.length; i++) {
            if (a_l.size()==0) {
                a_l.add(asteroids[i]);
            } else if (asteroids[i]<0 && a_l.get(a_l.size()-1)>0) {
                boolean add = false;
                while (a_l.size()>0 && a_l.get(a_l.size()-1)>0) {
                    if (a_l.get(a_l.size()-1) > (-1)*asteroids[i]) {
                        // asteroids[i] disappears
                        add = false;
                        break;
                    } else if (a_l.get(a_l.size()-1)==(-1)*asteroids[i]) {
                        // asteroids[i] and a_l.get(a_l.size()-1) disappear
                        a_l.remove(a_l.size()-1);
                        add = false;
                        break;
                    } else if (a_l.get(a_l.size()-1) < (-1)*asteroids[i]) {
                        a_l.remove(a_l.size()-1);
                        add = true;
                    }
                }
                if (add) a_l.add(asteroids[i]);
            } else {
                a_l.add(asteroids[i]);
            }
        }
        
        int[] answer = new int [a_l.size()];
        for (int i=0; i<a_l.size(); i++) {
            answer[i] = a_l.get(i);
        }
        return answer;
    }
}

/* Too slow, check all collisions until no collisions could happen
class Solution {
    public boolean checkFinished(List<Integer> asteriods) {
        if(asteriods.size()==0) return true;
        int start_pos=-1;
        //if (asteriods.get(0)<0) start_pos = 0;
        for (int i : asteriods) {
            if (i>0 && start_pos==-1) start_pos = 1;
            if (i<0 && start_pos==1) return false;
        }
        return true;
    }
    
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> a_l = new ArrayList<> ();
        for (int i=0; i<asteroids.length; i++) {
            a_l.add(asteroids[i]);
        }
        while (!checkFinished(a_l)) {
            // find the first collision
            for (int i=0; i<a_l.size()-1; i++) {
                if (a_l.get(i)>0 && a_l.get(i+1)<0) {
                    if (Math.abs(a_l.get(i))==Math.abs(a_l.get(i+1))) {
                        a_l.remove(i);
                        a_l.remove(i);
                    } else if (Math.abs(a_l.get(i))<Math.abs(a_l.get(i+1))) {
                        a_l.remove(i);
                    } else {
                        a_l.remove(i+1);
                    }
                }
            }
        }
        int[] answer = new int [a_l.size()];
        for (int i=0; i<a_l.size(); i++) {
            answer[i] = a_l.get(i);
        }
        return answer;
    }
}
*/