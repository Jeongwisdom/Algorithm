import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[] dp;
    static Deque<Integer> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);
        dp = new int[100001];
        q = new ArrayDeque<>();
        q.offer(k);
        dp[k] = 1;
        while (!q.isEmpty()) {
            int num = q.poll();
            int teleport = num / 2;
            if (num % 2 == 0) {
                add(teleport, dp[num]);
                if (teleport == n) break;
            }
            int plus = num + 1;
            add(plus, dp[num] + 1);
            if (plus == n) break;
            int minus = num - 1;
            add(minus, dp[num] + 1);
            if (minus == n) break;
        }
        dp[n]--;
        System.out.println(dp[n]);
    }
    
    static void add(int num, int step) {
        if (num >= 0 && num < 100001 && dp[num] == 0) {
            dp[num] = step;
            q.offer(num);
        }
    }
}