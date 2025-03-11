class Main {
    static int read() throws Exception {
        int n = 0, a;
        while ((a = System.in.read()) > 47) n = (n << 3) + (n << 1) + (a & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = read(), r = read(), c = read();
        System.out.println(z(N, r, c));
    }

    static int z(int N, int r, int c) {
        if (N == 0) return 0;
        int half = 1 << (N - 1);

        if (r < half && c < half) return z(N - 1, r, c);
        else if (r < half) return half * half + z(N - 1, r, c - half);
        else if (c < half) return 2 * half * half + z(N - 1, r - half, c);
        return 3 * half * half + z(N - 1, r - half, c - half);
    }
}
