import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prices = {5, 5, 5, 5, 5, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 5, 5, 5};
        int answer = 0;
        StringTokenizer st;
        String str;
        int h, m, d;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            d = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(str, ":");
            h = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (h != 6 && h != 18) answer += d * prices[h];
            else if (h == 6) {
                if (m + d > 60) {
                    answer += 5 * (m + d - 60);
                }
                answer += 5 * d;
            } else {
                if (m + d > 60) {
                    answer -= 5 * (m + d - 60);
                }
                answer += 10 * d;
            }
        }
        System.out.println(answer);
    }
}