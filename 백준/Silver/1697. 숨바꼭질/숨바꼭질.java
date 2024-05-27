import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
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