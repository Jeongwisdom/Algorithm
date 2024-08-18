import java.io.*;

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
        int buffer = 10000000;
        int[] arr = new int[2 * buffer + 1];
        for (int i = 0; i < n; i++) {
            arr[read() + buffer]++;
        }
        StringBuilder sb = new StringBuilder();
        int m = read();
        for (int i = 0; i < m; i++) {
            sb.append(arr[read() + buffer]).append(" ");
        }
        System.out.println(sb);
    }
}