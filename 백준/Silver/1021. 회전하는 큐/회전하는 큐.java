class Main {
    static int n;
    static boolean[] ch;

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        int m = read(), ex = 1, id, answer = 0;
        ch = new boolean[n + 1];
        while (m-- > 0) {
            id = read();
            answer += Math.min(two(ex, id), three(ex, id));
            if (m > 0) {
                ch[id] = true;
                while (ch[id]) {
                    id++;
                    if (id > n) id = 1;
                }
                ex = id;
            }
        }
        System.out.println(answer);
    }

    static int two(int to, int from) {
        int cnt = 0;
        while (to != from) {
            to++;
            if (to > n) to = 1;
            if (!ch[to]) cnt++;
        }
        return cnt;
    }

    static int three(int to, int from) {
        int cnt = 0;
        while (to != from) {
            to--;
            if (to == 0) to = n;
            if (!ch[to]) cnt++;
        }
        return cnt;
    }
}