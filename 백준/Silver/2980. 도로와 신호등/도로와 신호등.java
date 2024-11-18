class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int l = read();
        int d, r, g, time, answer = 0, ex = 0;
        for (int i = 0; i < n; i++) {
            d = read();
            r = read();
            g = read();
            answer += d - ex;
            time = answer % (r + g);
            if (time < r) answer += r - time;
            ex = d;
        }
        answer += l - ex;
        System.out.println(answer);
    }
}