import java.util.*;

class Solution {
    
    int answer;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] ch = new boolean[numbers.length()];
        answer = 0;
        
        DFS(numbers, ch, 0);
        
        for (int i: set) {
            if (isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    public void DFS(String numbers, boolean[] ch, int num) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!ch[i]) {
                ch[i] = true;
                set.add(num * 10 + numbers.charAt(i) - '0');
                DFS(numbers, ch, num * 10 + numbers.charAt(i) - '0');
                ch[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}