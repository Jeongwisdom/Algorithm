class Main {
    static int c, n;

    static int read() throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = read();
        }

        long answer = 0;
        int[] stack = new int[N];
        int[] num = new int[N];
        int see, id = -1;
        for (int i = N - 1; i >= 0; i--) {
            see = 0;
            while (id >= 0) {
                if (buildings[i] <= stack[id]) break;
                see += num[id] + 1;
                id--;
            }
            stack[++id] = buildings[i];
            num[id] = see;
            answer += see;
        }
        System.out.println(answer);
    }
}