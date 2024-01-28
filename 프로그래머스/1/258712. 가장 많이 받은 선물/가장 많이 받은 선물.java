import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Present> map = new HashMap<>();
        int length = friends.length;
        for (int i = 0; i < length; i++) {
            map.put(friends[i], new Present(i, length));
        }
        
        String[] s;
        Present a, b;
        int[] present = new int[friends.length];
        for (String gift: gifts) {
            s = gift.split(" ");
            a = map.get(s[0]);
            b = map.get(s[1]);
            a.give[b.idx]++;
            b.get[a.idx]++;
            present[a.idx]++;
            present[b.idx]--;
        }
        
        int[] next = new int[friends.length];
        for (int i = 0; i < friends.length - 1; i++) {
            a = map.get(friends[i]);
            for (int j = i + 1; j < friends.length; j++) {
                b = map.get(friends[j]);
                if (a.give[b.idx] > b.give[a.idx]) next[a.idx]++;
                else if (a.give[b.idx] < b.give[a.idx]) next[b.idx]++;
                else {
                    if (present[a.idx] > present[b.idx]) next[a.idx]++;
                    else if (present[a.idx] < present[b.idx]) next[b.idx]++;
                }
            }
        }
        
        int answer = 0;
        for (int n: next) {
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}

class Present {
    
    int idx;
    int[] give;
    int[] get;
    
    public Present(int idx, int length) {
        this.idx = idx;
        this.give = new int[length];
        this.get = new int[length];
    }
}