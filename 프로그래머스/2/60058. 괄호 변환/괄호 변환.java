import java.util.*;

class Solution {
    StringBuilder sb;
    
    public String solution(String p) {
        sb = new StringBuilder();
        divide(p);

        return sb.toString();
    }

    public void divide(String p) {
        if (p.isBlank()) return;
        int correct = 0;
        int incorrect = 0;
        int id = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                if (incorrect == 0) correct++;
                else {
                    incorrect--;
                    if (incorrect == 0) {
                        id = p.length();
                        appendIncorrect(p, i + 1);
                        break;
                    }
                }
            } else {
                if (correct == 0) incorrect++;
                else {
                    correct--;
                    if (correct == 0) {
                        id = i + 1;
                        sb.append(p.substring(0, id));
                        break;
                    }
                }
            }
        }
        divide(p.substring(id));
    }

    public void appendIncorrect(String p, int id) {
        String u = p.substring(0, id);
        String v = p.substring(id);
        sb.append('(');
        divide(v);
        sb.append(')');
        for (int i = 1; i < u.length() - 1; i++) {
            if (p.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
    }
}