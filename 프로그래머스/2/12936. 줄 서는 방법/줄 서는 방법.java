class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] ch = new boolean[n + 1];
        long[] fac = factorial(n);
        
        int id, count;
        for (int i = 0; i < answer.length; i++) {
            id = (int) (k / fac[n - (i + 1)]);
            k = (long) (k % fac[n - (i + 1)]);
            if (k == 0) {
                k = (long) fac[n - (i + 1)];
            } else id++;
            count = 0;
            for (int j = 1; j < ch.length; j++) {
                if (!ch[j]) {
                    count++;
                    if (id == count) {
                        id = j;
                        break;
                    }
                }
            }
            ch[id] = true;
            answer[i] = id;
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