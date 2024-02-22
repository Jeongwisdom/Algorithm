class Solution {
    public int[] solution(int[][] arr) {
        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};
        int[][] tmp;
        int ori;
        boolean ch;
        int zero = 0;
        int one = 0;
        while (arr.length > 1) {
            tmp = new int[arr.length / 2][arr.length / 2];
            for (int i = 0; i < arr.length; i += 2) {
                for (int j = 0; j < arr.length; j += 2) {
                    ori = arr[i][j];
                    ch = true;
                    int z = 0;
                    int o = 0;
                    for (int k = 0; k < dx.length; k++) {
                        if (arr[i + dx[k]][j + dy[k]] != ori) {
                            ch = false;
                        }
                        if (arr[i + dx[k]][j + dy[k]] == 0) z++;
                        else if(arr[i + dx[k]][j + dy[k]] == 1) o++;
                    }
                    if (ch) tmp[i / 2][j / 2] = ori;
                    else {
                        tmp[i / 2][j / 2] = 2;
                        zero += z;
                        one += o;
                    }
                }
            }
            arr = tmp;
        }
        
        if (arr[0][0] == 0) zero++;
        else if (arr[0][0] == 1) one++;
        
        return new int[] {zero, one};
    }
}