class Solution {
    public long solution(int r1, int r2) {
        long min = (long) r1 * r1;
        long max = (long) r2 * r2;
        long answer = 0;
        for (long x = 1; x <= r2; x++) {
            long pow = x * x;
            int small = (int) Math.ceil(Math.sqrt(min - pow));
            int big = (int) Math.sqrt(max - pow);
            answer += big - small + 1;
        }
        answer *= 4;
        return answer;
    }
}