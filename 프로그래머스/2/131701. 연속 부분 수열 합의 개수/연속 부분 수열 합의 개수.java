import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        for (int i = 1; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int num = 0;
                for (int k = 0; k < i; k++) {
                    int id = j + k >= elements.length? j + k - elements.length: j + k;
                    num += elements[id];
                }
                answer.add(num);
            }
        }
        
        return answer.size() + 1;
    }
}