class Main {
    static int read() throws Exception {
        int c, n = System.in.read();
        boolean minus = false;
        if (n < 48) {
            minus = true;
            n = System.in.read();
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[201];
        for (int i = 0; i < n; i++) {
            arr[read() + 100]++;
        }
        System.out.println(arr[read() + 100]);
    }
}