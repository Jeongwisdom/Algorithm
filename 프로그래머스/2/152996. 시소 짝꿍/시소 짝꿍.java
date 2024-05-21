class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] w = new long[1001];
        for (int i = 0; i < weights.length; i++) {
            w[weights[i]]++;
        }
        for (int i = 100; i < 1001; i++) {
            answer += w[i] * (w[i] - 1) / 2;
            if (i % 2 == 0) answer += w[i / 2] * w[i];
            if (i % 3 == 0) answer += w[i / 3 * 2] * w[i];
            if (i % 4 == 0) answer += w[i / 4 * 3] * w[i];
        }
        return answer;
    }
}