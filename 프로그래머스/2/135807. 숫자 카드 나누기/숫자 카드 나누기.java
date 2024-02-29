import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        for (int i: arrayA) {
            gcdA = gcd(i, gcdA);
        }
        int gcdB = arrayB[0];
        for (int i: arrayB) {
            gcdB = gcd(i, gcdB);
        }
        
        boolean flag = true;
        for (int i: arrayB) {
            if (i % gcdA == 0) {
                flag = false;
                break;
            }
        }
        if (flag) answer = gcdA;
        
        flag = true;
        for (int i: arrayA) {
            if (i % gcdB == 0) {
                flag = false;
                break;
            }
        }
        if (flag) answer = Math.max(answer, gcdB);
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}