import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] order = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(split[i]) - 1;
        }
        String[][] arr = new String[4][n];
        split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[0][i] = split[i];
        }
        
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = arr[i - 1][order[j]];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[3][i]).append("\n");
        }
        System.out.println(sb);
    }
}