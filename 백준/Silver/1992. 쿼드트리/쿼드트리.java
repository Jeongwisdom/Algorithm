import java.io.*;

class Main {
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        
        divide(arr, n, 0, 0);
        System.out.println(answer);
    }
    
    public static void divide(int[][] arr, int n, int x, int y) {
        int first = arr[x][y];
        boolean ch = true;
        loop:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != arr[i][j]) {
                    ch = false;
                    break loop;
                }
            }
        }
        
        if (!ch) {
            answer.append("(");
            for (int i = x; i < x + n; i += n / 2) {
                for (int j = y; j < y + n; j += n / 2) {
                    divide(arr, n / 2, i, j);
                }
            }
            answer.append(")");
        } else {
            answer.append(first);
        }
    }
}