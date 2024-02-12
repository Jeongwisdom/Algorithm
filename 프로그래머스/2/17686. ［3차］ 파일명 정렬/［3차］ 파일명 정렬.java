import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            int id1 = findDigit(s1);
            int id2 = findDigit(s2);
            String head1 = s1.substring(0, id1).toUpperCase();
            String head2 = s2.substring(0, id2).toUpperCase();
            int id3 = findNoDigit(id1, s1);
            int id4 = findNoDigit(id2, s2);
            int num1 = Integer.parseInt(s1.substring(id1, id3));
            int num2 = Integer.parseInt(s2.substring(id2, id4));
            if (head1.equals(head2)) return num1 - num2;
            return head1.compareTo(head2);
        });
        
        return files;
    }
    
    public int findDigit(String s) {
        int id = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                id = i;
                break;
            }
        }
        
        return id;
    }
    
    public int findNoDigit(int id, String s) {
        int idx = id + 5;
        for (int i = id + 1; i < id + 5; i++) {
            if (i == s.length() || !Character.isDigit(s.charAt(i))) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
}