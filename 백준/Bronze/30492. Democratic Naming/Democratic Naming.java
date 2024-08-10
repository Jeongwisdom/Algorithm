import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] arr = new int[m][26];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[j][str.charAt(j) - 'a']++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char c = 'a';
            int max = 0;
            for (int j = 0; j < 26; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    c = (char) ('a' + j);
                }
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}