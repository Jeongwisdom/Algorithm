import java.util.*;

class Solution {
    long answer;
    
    public long solution(String expression) {
        List<Long> num = new ArrayList<>();
        List<Character> oper = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int ex = 0;
        answer = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                oper.add(expression.charAt(i));
                set.add(expression.charAt(i));
                num.add(Long.parseLong(expression.substring(ex, i)));
                ex = i + 1;
            }
        }
        num.add(Long.parseLong(expression.substring(ex)));
        
        DFS(num, oper, set.toArray(new Character[0]), 0, new char[set.size()], new boolean[set.size()]);
        return answer;
    }
    
    public void DFS(List<Long> num, List<Character> oper, Character[] set, int count, char[] order, boolean[] ch) {
        if (count == set.length) {
            List<Long> number = new ArrayList<>(num);
            List<Character> operator = new ArrayList<>(oper);
            for (int i = 0; i < order.length; i++) {
                for (int j = 0; j < operator.size(); j++) {
                    if (order[i] == operator.get(j)) {
                        long result = operate(number.get(j), number.get(j + 1), operator.get(j));
                        number.remove(j + 1);
                        number.remove(j);
                        operator.remove(j);
                        number.add(j, result);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(number.get(0)));
        } else {
            for (int i = 0; i < set.length; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    order[count] = set[i];
                    DFS(num, oper, set, count + 1, order, ch);
                    ch[i] = false;
                }
            }
        }
    }
    
    public long operate(long a, long b, char c) {
        if (c == '+') return a + b;
        else if (c == '-') return a - b;
        else return a * b;
    }
}