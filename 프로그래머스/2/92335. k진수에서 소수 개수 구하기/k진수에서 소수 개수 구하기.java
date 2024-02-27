class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n, k).split("0");
        for (String str: split) {
            if (str.isEmpty()) continue;
            long num = Long.parseLong(str);
            if (num == 2) answer++;
            else if (num % 2 != 0 && isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n == 1) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}