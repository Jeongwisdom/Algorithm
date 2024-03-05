import java.io.*;

class Main {
    static int answer = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                arr[i][j++] = c;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int rowSum = 1;
            int colSum = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    char c = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = c;
                    count(arr, i , j);
                    count(arr, i, j + 1);
                    arr[i][j + 1] = arr[i][j];
                    arr[i][j] = c;
                    rowSum = 1;
                } else {
                    rowSum++;
                    answer = Math.max(answer, rowSum);
                }
                if (arr[j][i] != arr[j + 1][i]) {
                    char c = arr[j][i];
                    arr[j][i] = arr[j + 1][i];
                    arr[j + 1][i] = c;
                    count(arr, j, i);
                    count(arr, j + 1, i);
                    arr[j + 1][i] = arr[j][i];
                    arr[j][i] = c;
                    colSum = 1;
                } else {
                    colSum++;
                    answer = Math.max(answer, colSum);
                }
            }
        }
        
        System.out.println(answer);
    }
    
    public static void count(char[][] arr, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < dx.length; i++) {
            char c = arr[x][y];
            int sum = 0;
            int nx = x;
            int ny = y;
            while (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
                if (c == arr[nx][ny]) sum++;
                else break;
                nx = nx + dx[i];
                ny = ny + dy[i]; 
            }
            nx = x - dx[i];
            ny = y - dy[i];
            while (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
                if (c == arr[nx][ny]) sum++;
                else break;
                nx = nx - dx[i];
                ny = ny - dy[i]; 
            }
            answer = Math.max(answer, sum);
        }
    }
}