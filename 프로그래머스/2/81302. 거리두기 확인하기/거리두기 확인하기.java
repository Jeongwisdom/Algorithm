import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            char[][] arr = new char[5][5];
            Queue<int[]> q = new ArrayDeque<>();
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < 5; k++) {
                    arr[j][k] = places[i][j].charAt(k);
                    if (arr[j][k] == 'P') q.offer(new int[] {j, k});
                }
            }
            if (check(arr, q)) answer[i] = 1;
        }
        
        return answer;
    }
    
    public boolean check(char[][] arr, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int j = 1; j < 3; j++) {
                if (p[1] + j < 5 && arr[p[0]][p[1] + j] == 'P') return false;
                else if (p[1] + j < 5 && arr[p[0]][p[1] + j] == 'X') break;
            }
            for (int j = 1; j < 3; j++) {
                if (p[0] + j < 5 && arr[p[0] + j][p[1]] == 'P') return false;
                else if (p[0] + j < 5 && arr[p[0] + j][p[1]] == 'X') break;
            }
            if (p[0] + 1 < 5 && p[1] + 1 < 5 && arr[p[0] + 1][p[1] + 1] == 'P') {
                if (arr[p[0] + 1][p[1]] != 'X' || arr[p[0]][p[1] + 1] != 'X') return false;
            }
            if (p[0] + 1 < 5 && p[1] - 1 >= 0 && arr[p[0] + 1][p[1] - 1] == 'P') {
                if (arr[p[0] + 1][p[1]] != 'X' || arr[p[0]][p[1] - 1] != 'X') return false;
            }
        }
        
        return true;
    }
}