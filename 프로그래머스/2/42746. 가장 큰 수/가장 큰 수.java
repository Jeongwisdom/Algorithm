import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Number[] n = new Number[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            n[i] = new Number(numbers[i]);
        }
        Arrays.sort(n);
        
        StringBuilder answer = new StringBuilder();
        for (Number i: n) {
            answer.append(i.n);
        }
        return answer.charAt(0) == '0'? "0": answer.toString();
    }
}

class Number implements Comparable<Number> {
    
    int n;
    int digit;

    public Number(int n) {
        this.n = n;
        this.digit = n == 0? 1: (int) Math.pow(10, (int) Math.log10(n) + 1);
    }

    @Override
    public int compareTo(Number n) {
        if (this.n / this.digit != n.n / n.digit) return n.n - this.n;
        int n1 = n.n * this.digit+ this.n;
        int n2 = this.n * n.digit + n.n;
        return n1 == n2? n.n - this.n: n1 - n2;
    }
}