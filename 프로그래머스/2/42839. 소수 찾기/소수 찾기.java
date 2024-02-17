class Solution {
    
    int answer;
    int[] prime = new int[10000000];
    
    public int solution(String numbers) {
        boolean[] ch = new boolean[numbers.length()];
        answer = 0;
        prime[0] = 2;
        prime[1] = 2;
        
        DFS(numbers, ch, 0);
        
        return answer;
    }
    
    public void DFS(String numbers, boolean[] ch, int num) {
        if (prime[num] == 0) {
            if (isPrime(num)) answer++;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!ch[i]) {
                ch[i] = true;
                DFS(numbers, ch, num * 10 + numbers.charAt(i) - '0');
                ch[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (prime[num] == 2) return false;
        else if (prime[num] == 1) return true;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                prime[num] = 2;
                return false;
            }
        }
        
        prime[num] = 1;
        return true;
    }
}