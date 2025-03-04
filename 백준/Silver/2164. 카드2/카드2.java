class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) q[i] = i + 1;
        int head = 0, tail = 0;
        while ((head + 1) % n != tail) {
            q[tail] = q[(head + 1) % n];
            tail = (tail + 1) % n;
            head = (head + 2) % n;
        }
        System.out.println(q[head]);
    }
}