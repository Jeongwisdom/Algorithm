import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 45;
        if (m < 0) {
            m += 60;
            if (h < 1) System.out.print(23 + " " + m);
            else System.out.print(h - 1 + " " + m);
        } else System.out.print(h + " " + m);
    }
}