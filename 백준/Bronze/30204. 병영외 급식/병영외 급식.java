class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int x = read();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += read();
        }
        
        if (sum % x == 0) System.out.println(1);
        else System.out.println(0);
    }
}