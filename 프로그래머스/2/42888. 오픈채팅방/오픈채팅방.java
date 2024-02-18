import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        String[] tmp;
        for (int i = 0; i < record.length; i++) {
            tmp = record[i].split(" ");
            if (tmp[0].charAt(0) == 'E') {
                map.put(tmp[1], tmp[2]);
                list.add(new String[] {tmp[1], "님이 들어왔습니다."});
            } else if (tmp[0].charAt(0) == 'C') {
                map.put(tmp[1], tmp[2]);
            } else {
                list.add(new String[] {tmp[1], "님이 나갔습니다."});
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0, j = 0; i < list.size(); i++) {
            tmp = list.get(i);
            answer[i] = map.get(tmp[0]) + tmp[1];
        }
        
        return answer;
    }
}