class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = read(), K = read();
        int[] dist = new int[100001];
        int[] q = new int[100001];
        dist[N] = 1;
        q[0] = N;
        int head = 0, tail = 1;
        int[] num = new int[3];
        if (N == K) {
            System.out.println(0);
            return;
        }
        loop:
        while (head < tail) {
            num[0] = q[head] + 1;
            num[1] = q[head] - 1;
            num[2] = q[head] * 2;
            for (int i = 0; i < 3; i++) {
                if (num[i] < 0 || num[i] > 100000) continue;
                if (dist[num[i]]> 0) continue;
                dist[num[i]] = dist[q[head]] + 1;
                if (num[i] == K) break loop;
                q[tail++] = num[i];
            }
            head++;
        }
        System.out.println(dist[K] - 1);
    }
}