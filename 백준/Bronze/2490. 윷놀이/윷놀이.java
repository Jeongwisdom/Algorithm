import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zero = 0;
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) zero++;
            }
            if (zero == 0) sb.append("E\n");
            else if (zero == 1) sb.append("A\n");
            else if (zero == 2) sb.append("B\n");
            else if (zero == 3) sb.append("C\n");
            else sb.append("D\n");
        }
        System.out.println(sb);
    }
}