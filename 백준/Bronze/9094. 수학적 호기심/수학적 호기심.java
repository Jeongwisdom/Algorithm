import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int j = 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int cal = j * j + k * k + m;
                    if (cal % (j * k) == 0) answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}