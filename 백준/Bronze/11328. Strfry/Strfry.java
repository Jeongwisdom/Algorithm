import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (char c: st.nextToken().toCharArray()) {
                arr[c - 97]++;
            }
            
            for (char c: st.nextToken().toCharArray()) {
                arr[c - 97]--;
            }

            boolean ch = true;
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
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