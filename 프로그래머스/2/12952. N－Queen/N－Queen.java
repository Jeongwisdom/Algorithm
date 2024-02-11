class Solution {
    
    int answer;
    int[][] arr;
    
    public int solution(int n) {
        answer = 0;
        arr = new int[n][n];
        for (int i = 0; i < Math.ceil(n / 2.0); i++) {
            check(0, i, true);
            DFS(1, n);
            check(0, i, false);
            if (i == n / 2 - 1) answer *= 2;
        }
        
        return answer;
    }
    
    public void DFS(int count, int n) {
        if (count == n) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[count][i] == 0) {
                    check(count, i, true);
                    DFS(count + 1, n);
                    check(count, i, false);
                }
            }
        }
    }
    
    public void check(int row, int column, boolean ch) {
        for (int i = row + 1, j = 1; i < arr.length; i++, j++) {
            if (ch) {
                arr[i][column]++;
                if (column - j >= 0) arr[i][column - j]++;
                if (column + j < arr.length) arr[i][column + j]++;
            } else {
                arr[i][column]--;
                if (column - j >= 0) arr[i][column - j]--;
                if (column + j < arr.length) arr[i][column + j]--;
            }
        }
    }
}