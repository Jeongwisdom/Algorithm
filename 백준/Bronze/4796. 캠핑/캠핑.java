import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (l == 0 && p == 0 && v == 0) break;
            int answer = v / p * l;
            answer += v % p > l? l: v % p;
            bw.write("Case ");
            bw.write(String.valueOf(i));
            bw.write(": ");
            bw.write(String.valueOf(answer));
            bw.write("\n");
        }
        bw.flush();
    }
}