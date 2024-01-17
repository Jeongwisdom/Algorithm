import java.util.*;

class Solution {
    public long solution(long n) {
        String str = "" + n;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        long answer = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            answer = answer * 10 + chars[i] - '0';
        }
        return answer;
    }
}