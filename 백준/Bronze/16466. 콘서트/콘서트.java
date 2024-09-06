class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[] ch = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            ch[read()] = true;
        }
        
        for (int i = 1; i < 1000001; i++) {
            if (!ch[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}