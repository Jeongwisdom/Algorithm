import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{prices[0], 0});
        int[] answer = new int[prices.length];
        int[] tmp;
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                tmp = stack.pop();
                answer[tmp[1]] = i - tmp[1];
            }
            stack.push(new int[]{prices[i], i});
        }
        
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            answer[tmp[1]] = prices.length - 1 - tmp[1];
        }
        return answer;
    }
}