import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int i = 0;
        int last, pow, score;
        List<Integer> list = new ArrayList<>();
        
        while (i < dartResult.length()) {
            last = list.size() - 1;
            if (dartResult.charAt(i) == '*') {
                list.set(last, list.get(last) * 2);
                if (last != 0) {
                    list.set(last - 1, list.get(last - 1) * 2);
                }
            } else if (dartResult.charAt(i) == '#') {
                list.set(last, list.get(last) * -1);
            } else {
                score = dartResult.charAt(i) - '0';
                if (Character.isDigit(dartResult.charAt(i + 1))) {
                    score = score * 10 + dartResult.charAt(i + 1) - '0';
                    i++;
                }
                if (dartResult.charAt(i + 1) == 'D') pow = 2;
                else if (dartResult.charAt(i + 1) == 'T') pow = 3;
                else pow = 1;
                list.add((int) Math.pow(score, pow));
                i++;
            }
            i++;
        }

        return list.stream().mapToInt(a -> a).sum();
    }
}