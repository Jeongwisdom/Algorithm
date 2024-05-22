class Solution {
    public long solution(int r1, int r2) {
        long max = Math.max(r1, r2);
        long min = Math.min(r1, r2);
        long pMax = max * max;
        long pMin = min * min;
        long answer = (max - min + 1) * 4;
        long in = 0;
        for (long x = 1; x < max; x++) {
            long pow = x * x;
            double small = Math.sqrt(pMin - pow);
            double big = Math.sqrt(pMax - pow);
            in += (int) big - (int) small;
            if (small != 0 && small % 1 == 0) in++;
        }
        answer += in * 4;
        return answer;
    }
}