class Main {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        hanoi(n, 1, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void hanoi(int n, int a, int b) {
        if (n == 0) return;
        cnt++;
        hanoi(n - 1, a, 6 - a - b);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(n - 1, 6 - a - b, b);
    }
}