import java.io.*;
import java.util.*;

class Main {
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; ; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (j != 0) answer.append("\n");
            BF(arr, 0, new StringBuilder(), 0);
        }
        System.out.print(answer);
    }
    
    public static void BF(int[] arr, int count, StringBuilder sb, int id) {
        if (count == 6) {
            answer.append(sb).append("\n");
        } else {
            for (int i = id; i <= arr.length - 6 + count; i++) {
                StringBuilder s = new StringBuilder(sb);
                s.append(arr[i]).append(" ");
                BF(arr, count + 1, s, i + 1);
            }
        }
    }
}