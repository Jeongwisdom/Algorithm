class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = read();
            int b = read();
            if (a == 0 && b == 0) break;
            if (a > b) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.println(sb);
    }
}