class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int a = read(), b = read(), c = read();
        System.out.println(rec(a, b, c));
    }
    
    static long rec(int a, int b, int c) {
        if (b == 1) return a % c;
        long val = rec(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) return val;
        return a * val % c;
    }
}