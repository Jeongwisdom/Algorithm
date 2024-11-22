class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int x, y, answer = 0, n = read();
        boolean[] ch = new boolean[10001];
        for (int i = 0; i < n; i++) {
            x = read();
            y = read();
            for (int j = x; j < y; j++) {
                if (!ch[j]) {
                    answer++;
                    ch[j] = true;
                }
            }
        }
        System.out.println(answer);
    }
}