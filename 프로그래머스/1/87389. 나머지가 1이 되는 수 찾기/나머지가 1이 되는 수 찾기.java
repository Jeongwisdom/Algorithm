class Solution {
    public int solution(int n) {
        int answer = n - 1;
        
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 1) return i;
        }
        
        return answer;
    }
}