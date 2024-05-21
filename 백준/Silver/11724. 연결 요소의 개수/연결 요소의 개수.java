import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean[] ch = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                answer++;
                ch[i] = true;
                q.offer(i);
            }
            while (!q.isEmpty()) {
                int a = q.poll();
                l = list.get(a);
                for (int b: l) {
                    if (!ch[b]) {
                        ch[b] = true;
                        q.offer(b);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}