class Main {
    static int read() throws Exception {
        boolean minus = false;
        int c, n = System.in.read();
        if (n == 45) {
            n = System.in.read();
            minus = true;
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }

    public static void main(String[] args) throws Exception {
        int num, n = read(), L = read() - 1;
        int[][] q = new int[n][2];
        int head = 0, tail = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            num = read();
            if (head < tail && q[head][0] < i - L) head++;
            while (tail > head && q[tail - 1][1] >= num) tail--;
            q[tail][0] = i;
            q[tail][1] = num;
            tail++;
            sb.append(q[head][1]).append(" ");
        }
        System.out.println(sb);
    }
}