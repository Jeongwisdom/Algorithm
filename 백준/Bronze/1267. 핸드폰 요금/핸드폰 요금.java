import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            y += 10 * (num / 30 + 1);
            m += 15 * (num / 60 + 1);
        }
        StringBuilder sb = new StringBuilder();
        if (y == m) sb.append("Y M ").append(y);
        else if (y < m) sb.append("Y ").append(y);
        else sb.append("M ").append(m);
        System.out.println(sb);
    }
}