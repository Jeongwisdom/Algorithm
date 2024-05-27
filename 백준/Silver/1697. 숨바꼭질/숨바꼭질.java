import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = Math.max(n, k);
        boolean[] ch = new boolean[max * 2];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        int answer = 0;
        loop:
        while (!q.isEmpty()) {
            Queue<Integer> tmp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int num = q.poll();
                if (num == n) break loop;
                if (!ch[num]) {
                    ch[num] = true;
                    if (num < ch.length - 1 && !ch[num + 1]) tmp.offer(num + 1);
                    if (num >= 1 && !ch[num - 1]) tmp.offer(num - 1);
                    if (num % 2 == 0 && !ch[num / 2]) tmp.offer(num / 2);
                }
            }
            q = tmp;
            answer++;
        }
        System.out.println(answer);
    }
}