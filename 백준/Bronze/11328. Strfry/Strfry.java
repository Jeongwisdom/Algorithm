import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] arr;
        for (int i = 0; i < n; i++) {
            arr = new int[2][26];
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < split[j].length(); k++) {
                    arr[j][split[j].charAt(k) - 97]++;
                }
            }

            boolean ch = true;
            for (int j = 0; j < 26; j++) {
                if (arr[0][j] != arr[1][j]) {
                    ch = false;
                    break;
                }
            }

            if (ch) sb.append("Possible");
            else sb.append("Impossible");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}