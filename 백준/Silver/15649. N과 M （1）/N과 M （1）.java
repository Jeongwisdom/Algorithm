class Main {
    static int n, m;
    static int[] ch, arr;
    static StringBuilder sb = new StringBuilder();

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        ch = new int[n + 1];
        arr = new int[m];
        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int id) {
        if (id == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (ch[i] == 1) continue;
            ch[i] = 1;
            arr[id] = i;
            backTracking(id + 1);
            ch[i] = 0;
        }
    }
}