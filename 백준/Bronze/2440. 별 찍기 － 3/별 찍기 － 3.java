class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        String s = "*";
        int n = read();
        for (int i = n; i > 0; i--) {
            sb.append(s.repeat(i)).append("\n");
        }
        System.out.println(sb);
    }
}