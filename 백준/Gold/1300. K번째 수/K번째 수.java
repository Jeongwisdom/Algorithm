import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        
        int min = 1;
        int max = k;
        while (min <= max) {
            int mid = (min + max) >> 1;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(min);
    }
}