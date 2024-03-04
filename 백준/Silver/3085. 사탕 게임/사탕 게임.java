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
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    char c = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = c;
                    count(arr);
                    arr[i][j + 1] = arr[i][j];
                    arr[i][j] = c;
                }
                if (arr[j][i] != arr[j + 1][i]) {
                    char c = arr[j][i];
                    arr[j][i] = arr[j + 1][i];
                    arr[j + 1][i] = c;
                    count(arr);
                    arr[j + 1][i] = arr[j][i];
                    arr[j][i] = c;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    public static void count(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int rowSum = 1;
            int colSum = 1;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) rowSum++;
                else rowSum = 1;
                if (arr[j][i] == arr[j + 1][i]) colSum++;
                else colSum = 1;
                answer = Math.max(answer, rowSum);
                answer = Math.max(answer, colSum);
            }
        }
    }
}