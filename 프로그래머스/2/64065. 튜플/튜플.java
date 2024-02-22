import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] split = s.split("},");
        List<int[]> list = new ArrayList<>();
        for (String str: split) {
            str = str.replaceAll("[\\{}]", "");
            String[] num = str.split(",");
            int[] arr = new int[num.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(num[i]);
            }
            list.add(arr);
        }
        
        int[] answer = new int[list.size()];
        Collections.sort(list, (i1, i2) -> i1.length - i2.length);
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            loop:
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k <= i; k++) {
                    if (arr[j] == answer[k]) continue loop;
                }
                answer[i] = arr[j];
            }
        } 
        
        return answer;
    }
}