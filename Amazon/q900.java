// 2022.06.28
// Problem Statement:
// https://leetcode.com/problems/rle-iterator/

// idea: use curr_idx to track the which idx (0, 2, 4...) the count is in,
// and use curr_pos to track inside that count, which position the iterator is currently on,
// eg: encoding = [4, 5, 3, 8], curr_idx=2, curr_pos=1,
// means the iterator is on the idx-1 of the idx-2 number (the 2nd of 8)
class RLEIterator {
    int [] encoding_array;
    int curr_idx;
    int curr_pos;
    public RLEIterator(int[] encoding) {
        encoding_array = new int [encoding.length];
        encoding_array = encoding;
        curr_idx=0;
        curr_pos=0;
    }
    
    public int next(int n) {
        int ret = 0;
        while (n>0) {
            if (curr_idx>encoding_array.length-2) return -1; // out of boundary
            int rest = encoding_array[curr_idx] - curr_pos; // the rest amount in the current number
            if (rest>n) { // still have rest after iterating n times
                curr_pos += n;
                return encoding_array[curr_idx+1];
            } else if (rest==n) { // just run out of the current number, move to the next number
                curr_idx += 2;
                curr_pos = 0;
                return encoding_array[curr_idx-1];
            } else { // current number does not have enough amount, move to the next number
                curr_pos = 0;
                n -= rest;
                curr_idx += 2;
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */