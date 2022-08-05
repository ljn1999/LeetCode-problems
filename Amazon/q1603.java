// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/design-parking-system/

// idea: trivial
class ParkingSystem {
    public int Big;
    public int Medium;
    public int Small;
    
    public ParkingSystem(int big, int medium, int small) {
        Big = big;
        Medium = medium;
        Small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType==1) {
            if (Big>0) {
                Big--;
                return true;
            }
            return false;
        } else if (carType==2) {
            if (Medium>0) {
                Medium--;
                return true;
            }
            return false;
        } else {
            if (Small>0) {
                Small--;
                return true;
            }
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */