import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = min + 1; i < max; i++) {
            sb.append(i).append(" ");
            num++;
        }
        System.out.println(num);
        System.out.println(sb);
    }
}