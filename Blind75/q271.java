// 2022.09.21
// Problem Statement:
// https://leetcode.com/problems/encode-and-decode-strings/

// idea: encode: length + / + string
// decode: right = /'s idx, left to right is the size, get the string from right+1,
// then move left to /'s idx + size + 1 (starting idx of next length),
// move right to 1 after left to avoid checking on '/' in string value
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String send = "";
        for (String s : strs) {
            send = send + String.valueOf(s.length());
            send = send + "/";
            send = send + s;
        }
        return send;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> answer = new ArrayList<> ();
        String temp = "";
        int left = 0;
        int right = 0;
        while (right<s.length()) {
            if (s.charAt(right)=='/') {
                int size = Integer.valueOf(s.substring(left, right));
                left = right+size+1;
                answer.add(s.substring(right+1, right+size+1));
                right = left+1;
            } else {
                right++;
            }
        }
        return answer;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));