class Solution {
    public int solution(int n) {
        if (n == 1) return 1;
        int answer = 1;
        int sum = 0;
        
        for (int i = 1, j = 1; i <= Math.ceil(n / 2.0); i++) {
            sum += i;
            while (sum > n) {
                sum -= j;
                j++;
            }
            if (sum == n) answer++;
        }
        
        return answer;
    }
}