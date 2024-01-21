class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (divisor(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    public int divisor(int num) {
        if (num == 1) return 1;
        
        int answer = 2;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) answer++;
        }
        
        return answer;
    }
}