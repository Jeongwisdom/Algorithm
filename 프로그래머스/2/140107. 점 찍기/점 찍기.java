class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dis = (long) Math.pow(d, 2);
        for (int i = 0; i <= d; i += k) {
            long pow = (long) Math.pow(i, 2);
            answer += (long) Math.sqrt(dis - pow) / k + 1;
        }
        
        return answer;
    }
}