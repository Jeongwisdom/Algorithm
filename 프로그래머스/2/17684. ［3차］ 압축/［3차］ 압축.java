import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            list.add(String.valueOf(c));
        }
        
        List<Integer> ans = new ArrayList<>();
        String str = "";
        int k = 1;
        for (int i = 0; i < msg.length(); i += k) {
            for (int j = list.size() - 1; j >= 0; j--) {
                if (msg.substring(i).startsWith(list.get(j))) {
                    str = list.get(j);
                    k = str.length();
                    ans.add(j + 1);
                    break;
                }
            }
            
            if (i + str.length() < msg.length()) list.add(msg.substring(i, i + str.length() + 1));
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}