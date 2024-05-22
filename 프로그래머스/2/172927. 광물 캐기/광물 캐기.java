import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int count = picks[0] + picks[1] + picks[2];
        int[][] arr = new int[minerals.length / 5 + 1][3];
        for (int i = 0, id = 0; i < minerals.length; i += 5, id++, count--) {
            if (count == 0) break;
            int[] mineral = new int[3];
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;
                if (minerals[j].equals("stone")) mineral[2]++;
                else if (minerals[j].equals("iron")) mineral[1]++;
                else mineral[0]++;
            }
            arr[id] = mineral;
        }
        
        int answer = 0;
        Arrays.sort(arr, (a1, a2) -> {
            if (a2[0] == a1[0]) {
                if (a2[1] == a1[1]) return a2[2] - a1[2];
                return a2[1] - a1[1];
            }
            return a2[0] - a1[0];
        });
        for (int i = 0; i < arr.length; i++) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            int id = 2;
            if (picks[0] > 0) id = 0;
            else if (picks[1] > 0) id = 1;
            picks[id]--;
            answer += arr[i][0] * Math.pow(5, id) + arr[i][1] * Math.pow(5, id - 1 <= 0? 0: id - 1) + arr[i][2] * Math.pow(5, id - 2 <= 0? 0: id - 2);
        }
        return answer;
    }
}