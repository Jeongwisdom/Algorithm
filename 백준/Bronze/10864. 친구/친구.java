class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[] arr = new int[n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            a = read();
            b = read();
            arr[a]++;
            arr[b]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}