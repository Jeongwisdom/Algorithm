import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = Math.max(n, k);
        boolean[] ch = new boolean[max * 2 + 1];
        int[] arr = new int[max * 2 + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        ch[k] = true;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == n) break;
            if (num < ch.length - 1 && !ch[num + 1]) {
                ch[num + 1] = true;
                arr[num + 1] = arr[num] + 1;
                q.offer(num + 1);
            }
            if (num >= 1 && !ch[num - 1]) {
                ch[num - 1] = true;
                arr[num - 1] = arr[num] + 1;
                q.offer(num - 1);
            }
            if (num % 2 == 0 && !ch[num / 2]) {
                ch[num / 2] = true;
                arr[num / 2] = arr[num] + 1;
                q.offer(num / 2);
            }
        }
        System.out.println(arr[n]);
    }
}