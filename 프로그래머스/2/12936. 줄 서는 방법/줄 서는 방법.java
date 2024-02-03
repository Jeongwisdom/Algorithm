import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long[] fac = factorial(n);
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        int id;
        for (int i = 0; i < answer.length; i++) {
            id = (int) (k / fac[n - (i + 1)]);
            k = (long) (k % fac[n - (i + 1)]);
            if (k == 0) {
                k = (long) fac[n - (i + 1)];
            } else id++;
            answer[i] = list.remove(id - 1);
        }
        
        return answer;
    }
    
    public long[] factorial(int n) {
        long[] fac = new long[n];
        fac[0] = 1;
        fac[1] = 1;
        
        for (int i = 2; i < fac.length; i++) {
            fac[i] = fac[i - 1] * i;
        }

        return fac;
    }
}