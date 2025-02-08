class Main {
    static int n, k, max = 0;
    static int[] answer, mingu;

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = read();
        }
        mingu = new int[n];
        for (int i = 0; i < n; i++) {
            mingu[i] = read();
        }
        DFS(0, 0, 0, 0);
        System.out.println(max);
    }

    static void DFS(int problem, int id, int usedK, int ans) {
        if (problem >= n || id >= n) {
            if (max < ans) max = ans;
            return;
        }
        if (answer[problem] == mingu[id]) DFS(problem + 1, id + 1, usedK, ans + 1);
        else DFS(problem + 1, id + 1, usedK, ans);
        if (usedK < k) {
            for (int i = 1; i <= k - usedK; i++) {
                if (id + i >= n) break;
                if (answer[problem] == mingu[id + i]) DFS(problem + 1, id + i + 1, usedK + i, ans + 1);
                else DFS(problem + 1, id + i + 1, usedK + i, ans);
            }
            if (id + 1 < n) {
                if (answer[problem] == mingu[id + 1]) DFS(problem + 1, id + 2, usedK + 1, ans + 1);
                else DFS(problem + 1, id + 2, usedK + 1, ans);
            }
            DFS(problem + 1, id, usedK + 1, ans);
        }
    }
}