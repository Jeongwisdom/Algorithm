class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows + 1][columns + 1];
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = k++;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            int ex = arr[x1 + 1][y1];
            int min = ex;
            int nx = x1;
            int ny = y1;
            int count = 0;
            while (count++ < ((x2 - x1) + (y2 - y1)) * 2) {
                int tmp = arr[nx][ny];
                arr[nx][ny] = ex;
                ex = tmp;
                min = Math.min(min, ex);
                if (count <= (y2 - y1)) ny++;
                else if (count <= (y2 - y1) + (x2 - x1)) nx++;
                else if (count <= (y2 - y1) * 2 + (x2 - x1)) ny--;
                else nx--;
            }
            arr[nx][ny] = ex;
            answer[i] = min;
        }
        
        return answer;
    }
}