class Main {
    static int N, S, answer = 0;
    static int[] arr;

    static int read() throws Exception {
        boolean minus = false;
        int c, n = System.in.read();
        if (n == 45) {
            minus = true;
            n = System.in.read();
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }

    public static void main(String[] args) throws Exception {
        N = read();
        S = read();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }
        backTracking(0, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }

    static void backTracking(int id, int sum) {
        if (id == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        backTracking(id + 1, sum);
        backTracking(id + 1, sum + arr[id]);
    }
}