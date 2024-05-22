class Solution {
    public long solution(int r1, int r2) {
        long min = (long) r1 * r1;
        long max = (long) r2 * r2;
        long answer = r2 - r1 + 1;
        for (long x = 1; x < r2; x++) {
            long pow = x * x;
            double small = Math.sqrt(min - pow);
            double big = Math.sqrt(max - pow);
            answer += (int) big - (int) small;
            if (small != 0 && small % 1 == 0) answer++;
        }
        answer *= 4;
        return answer;
    }
}