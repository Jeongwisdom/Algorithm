import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set;
        String[] reporting;
        
        for (String s: report) {
            reporting = s.split(" ");
            set =  map.getOrDefault(reporting[1], new HashSet<String>());
            set.add(reporting[0]);
            map.put(reporting[1], set);
        }
        
        for (Set<String> reportee: map.values()) {
            if (reportee.size() >= k) {
                for (String reporter: reportee) {
                    for (int i = 0; i < id_list.length; i++) {
                        if (id_list[i].equals(reporter)) {
                            answer[i]++;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}