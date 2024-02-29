import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (i1, i2) -> {
            if (i1[col - 1] == i2[col - 1]) return i2[0] - i1[0];
            return i1[col - 1] - i2[col - 1];
        });
        
        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            answer = answer ^ sum;
        }
        
        return answer;
    }
}