class Main {
    static int read() throws Exception {
        int c, n = System.in.read();
        boolean minus = false;
        if (n < 48) {
            minus = true;
            n = 0;
        } else n &= 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -1 * n: n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int buffer = 1000000;
        boolean[] arr = new boolean[2 * buffer + 1];
        for (int i = 0; i < n; i++) {
            arr[read() + buffer] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) sb.append(i - buffer).append("\n");
        }
        System.out.println(sb);
    }
}