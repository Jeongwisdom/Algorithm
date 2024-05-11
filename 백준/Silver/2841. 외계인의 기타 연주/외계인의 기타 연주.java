import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int p = read();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }
        Queue<Integer> q;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int line = read();
            int num = read();
            q = map.get(line);
            while (!q.isEmpty() && q.peek() > num) {
                q.poll();
                answer++;
            }
            if (q.isEmpty() || q.peek() < num) {
                q.offer(num);
                answer++;
            }
        }
        System.out.println(answer);
    }
}