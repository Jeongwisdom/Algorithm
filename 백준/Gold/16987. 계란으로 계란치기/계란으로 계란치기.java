class Main {
    static int N, answer = 0;
    static int[] S, W;

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        N = read();
        S = new int[N];
        W = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = read();
            W[i] = read();
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int n) {
        if (n == N) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (S[i] <= 0) {
                    max++;
                }
            }
            answer = Math.max(answer, max);
            return;
        }

        if (S[n] <= 0) {
            dfs(n + 1);
            return;
        }

        boolean ch = false;
        for (int i = 0; i < N; i++) {
            if (i == n) continue;
            if (S[i] <= 0) continue;
            S[n] -= W[i];
            S[i] -= W[n];
            dfs(n + 1);
            S[n] += W[i];
            S[i] += W[n];
            ch = true;
        }
        if (!ch) dfs(n + 1);
    }
}