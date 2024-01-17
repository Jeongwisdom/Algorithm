import java.util.*;

class Solution {
    public long solution(long n) {
        String str = "" + n;
        List<Long> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list, Collections.reverseOrder());
        long answer = 0;
        for (long l: list) {
            answer *= 10;
            answer += l;
        }
        return answer;
    }
}