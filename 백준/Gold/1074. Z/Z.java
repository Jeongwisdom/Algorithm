class Main {
    static int answer, N, r, c;

    static int read() throws Exception {
        int a, b = System.in.read() & 15;
        while ((a = System.in.read()) > 47) b = (b << 3) + (b << 1) + (a & 15);
        return b;
    }

    public static void main(String[] args) throws Exception {
        N = read();
        r = read();
        c = read();
        int num = 1 << N - 1;
        z(0, 0, num, 0);
        System.out.println(answer);
    }

    static void z(int x, int y, int num, int cnt) {
        if (x == r && y == c) {
            answer = cnt;
            return;
        }
        int sum = num * num;
        if (x <= r && r < x + num && y <= c && c < y + num) z(x, y, num >> 1, cnt);
        else if (x <= r && r < x + num && y + num <= c && c < y + num + num) z(x, y + num, num >> 1, cnt + sum);
        else if (x + num <= r && r < x + num + num && y <= c && c < y + num) z(x + num, y, num >> 1, cnt + sum + sum);
        else if (x + num <= r && r < x + num + num && y + num <= c && c < y + num + num) z(x + num, y + num, num >> 1, cnt + sum + sum + sum);
    }
}