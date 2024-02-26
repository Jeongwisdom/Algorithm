import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
        }
        
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if (!check(places[i], j, k)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(String[] place, int i, int j) {
        for (int k = 1; k < 3; k++) {
            if (j + k < 5 && place[i].charAt(j + k) == 'P') return false;
            else if (j + k < 5 && place[i].charAt(j + k) == 'X') break;
        }
        for (int k = 1; k < 3; k++) {
            if (i + k < 5 && place[i + k].charAt(j) == 'P') return false;
            else if (i + k < 5 && place[i + k].charAt(j) == 'X') break;
        }
        if (i + 1 < 5 && j + 1 < 5 && place[i + 1].charAt(j + 1) == 'P') {
            if (place[i + 1].charAt(j) != 'X' || place[i].charAt(j + 1) != 'X') return false;
        }
        if (i + 1 < 5 && j - 1 >= 0 && place[i + 1].charAt(j - 1) == 'P') {
            if (place[i + 1].charAt(j) != 'X' || place[i].charAt(j - 1) != 'X') return false;
        }
        
        return true;
    }
}