import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);
        int answer = 0;
        for (int i = 0; i < targets.length; i++) {
            int end = targets[i][1];
            answer++;
            while (i + 1 < targets.length && targets[i + 1][0] < end) i++;
        }
        return answer;
    }
}