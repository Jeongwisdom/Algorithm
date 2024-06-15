import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] dp = new int[100001];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(k);
        dp[k] = 1;
        while (!q.isEmpty()) {
            int num = q.poll();
            int teleport = num / 2;
            if (num % 2 == 0 && teleport >= 0 && teleport < 100001 && dp[teleport] == 0) {
                dp[teleport] = dp[num];
                q.offer(teleport);
                if (teleport == n) break;
            }
            int plus = num + 1;
            if (plus >= 0 && plus < 100001 && dp[plus] == 0) {
                dp[plus] = dp[num] + 1;
                q.offer(plus);
                if (plus == n) break;
            }
            int minus = num - 1;
            if (minus >= 0 && minus < 100001 && dp[minus] == 0) {
                dp[minus] = dp[num] + 1;
                q.offer(minus);
                if (minus == n) break;
            }
        }
        dp[n]--;
        System.out.println(dp[n]);
    }
}