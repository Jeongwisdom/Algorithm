import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int num = 0;
        String[] tmp;
        for (int i = 0; i < record.length; i++) {
            tmp = record[i].split(" ");
            if (tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
                num++;
            } else if (tmp[0].equals("Change")) {
                map.put(tmp[1], tmp[2]);
            } else {
                num++;
            }
        }
        
        String[] answer = new String[num];
        for (int i = 0, j = 0; i < record.length; i++) {
            tmp = record[i].split(" ");
            if (tmp[0].equals("Enter")) {
                answer[j++] = map.get(tmp[1]) + "님이 들어왔습니다.";
            } else if (tmp[0].equals("Leave")) {
                answer[j++] = map.get(tmp[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}