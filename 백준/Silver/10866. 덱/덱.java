import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * n + 1];
        int h = n;
        int t = n;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push_front")) {
                arr[h--] = Integer.parseInt(st.nextToken());
            } else if (str.equals("push_back")) {
                arr[++t] = Integer.parseInt(st.nextToken());
            } else if (str.equals("pop_front")) {
                if (h == t) sb.append("-1\n");
                else sb.append(arr[++h]).append("\n");
            } else if (str.equals("pop_back")) {
                if (h == t) sb.append("-1\n");
                else sb.append(arr[t--]).append("\n");
            } else if (str.equals("size")) {
                sb.append(t - h).append("\n");
            } else if (str.equals("empty")) {
                if (t - h == 0) sb.append("1\n");
                else sb.append("0\n");
            } else if (str.equals("front")) {
                if (h == t) sb.append("-1\n");
                else sb.append(arr[h + 1]).append("\n");
            } else {
                if (h == t) sb.append("-1\n");
                else sb.append(arr[t]).append("\n");
            }
        }
        System.out.println(sb);
    }
}