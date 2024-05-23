import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (p1, p2) -> p1[1].compareTo(p2[1]));
        String[] answer = new String[plans.length];
        Stack<String[]> s = new Stack<>();
        s.push(plans[0]);
        int id = 0;
        for (int i = 1; i < plans.length; i++) {
            int time = calculateTime(plans[i][1]) - calculateTime(plans[i - 1][1]);
            while (!s.isEmpty() && time >= Integer.parseInt(s.peek()[2])) {
                time -= Integer.parseInt(s.peek()[2]);
                answer[id++] = s.pop()[0];
            }
            if (!s.isEmpty() && time > 0) s.peek()[2] = Integer.parseInt(s.peek()[2]) - time + "";
            s.push(plans[i]);
        }
        while (!s.isEmpty()) {
            answer[id++] = s.pop()[0];
        }
        return answer;
    }
    
    int calculateTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}