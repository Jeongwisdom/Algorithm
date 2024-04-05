import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[21];
        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s, k = e; j <= (s + e) / 2; j++, k--) {
                int tmp = arr[j];
                arr[j] = arr[k];
                arr[k] = tmp;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 21; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}