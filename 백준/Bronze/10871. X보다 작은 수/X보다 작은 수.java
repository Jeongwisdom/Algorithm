class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int x = read();
        StringBuilder sb = new StringBuilder();
        int num;
        for (int i = 0; i < n; i++) {
            num = read();
            if (num < x) sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}