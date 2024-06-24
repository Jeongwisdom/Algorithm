class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int m = read();
        int a, b, answer = 1;
        for (int i = 0; i < m; i++) {
            a = read();
            b = read();
            if (answer == a) answer = b;
            else if (answer == b) answer = a;
        }
        System.out.println(answer);
    }
}