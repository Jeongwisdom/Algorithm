import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        String[] t;
        Time time = new Time(today);
        
        for (String term: terms) {
            t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        
        Time start;
        int limit;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            t = privacies[i].split(" ");
            start = new Time(t[0]);
            limit = map.get(t[1]);
            if (!time.validateTerm(start, limit)) list.add(i + 1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

class Time {
    
    int y;
    int m;
    int d;
    
    public Time(String s) {
        String[] time = s.split("\\.");
        this.y = Integer.parseInt(time[0]);
        this.m = Integer.parseInt(time[1]);
        this.d = Integer.parseInt(time[2]);
    }
    
    public boolean validateTerm(Time start, int limit) {
        start.m += limit;
        start.d--;
        if (start.m > 12) {
            int add = start.m / 12;
            start.m = start.m % 12;
            if (start.m == 0) {
                start.m = 12;
                start.y--;
            }
            start.y += add;
        }
        if (start.d < 1) {
            start.d = 28;
            start.m--;
        }
        
        if (this.y > start.y || (this.y == start.y && this.m > start.m) || (this.y == start.y && this.m == start.m && this.d > start.d)) return false;
        else return true;
    }
}