import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int[] w = new int[1001];
        for (int i = 0; i < weights.length; i++) {
            answer += w[weights[i]];
            if (weights[i] % 2 == 0) answer += w[weights[i] / 2];
            if (weights[i] % 3 == 0) answer += w[weights[i] / 3 * 2];
            if (weights[i] % 4 == 0) answer += w[weights[i] / 4 * 3];
            w[weights[i]]++;
        }
        return answer;
    }
}