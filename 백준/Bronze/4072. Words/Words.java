import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder n;
        StringTokenizer st;
        loop:
        while (true) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                n = new StringBuilder(st.nextToken());
                if (n.toString().equals("#")) break loop;
                sb.append(n.reverse()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}