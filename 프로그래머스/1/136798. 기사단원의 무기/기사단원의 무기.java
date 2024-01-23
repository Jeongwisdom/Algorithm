class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int str;
        
        for (int i = 1; i <= number; i++) {
            str = divisor(i);
            if (str > limit) answer += power;
            else answer += str;
        }
        
        return answer;
    }
    
    public int divisor(int num) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) count++;
        }
        
        return Math.pow((int) Math.sqrt(num), 2) == num? count * 2 - 1: count * 2;
    }
}