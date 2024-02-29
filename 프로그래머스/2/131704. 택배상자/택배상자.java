import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        for (int i = 0, j = 1; i < order.length; i++) {
            while (j <= order.length && j < order[i]) {
                s.push(j++);
            }
            if (order[i] == j) {
                answer++;
                j++;
            } else {
                if (order[i] == s.peek()) {
                    s.pop();
                    answer++;
                } else return answer;
            }
        }
        
        return answer;
    }
}