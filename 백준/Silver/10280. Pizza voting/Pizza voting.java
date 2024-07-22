import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = 1;
        int e = n;
        for (int i = 0; i < n - 1; i++) {
            if (i % 3 == 0) e--;
            else if (i % 3 == 1) s++;
            else {
                if (m - s >= e - m) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println((s == e && s == m)? "YES": "NO");
    }
}