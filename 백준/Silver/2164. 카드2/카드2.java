class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int two = 1;
        while (two <= n) {
            two = two << 1;
        }
        two = two >> 1;
        System.out.println(n == two? n: (n - two) << 1);
    }
}