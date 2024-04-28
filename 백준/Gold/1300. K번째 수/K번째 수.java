import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        long n = read();
        int k = read();
        
        long min = 1;
        long max = n * n;
        while (min <= max) {
            long mid = (min + max) >> 1;
            long count = 0;
            for (long i = 1; i <= n; i++) {
                if (mid < i) break;
                long div = n * i;
                if (div > mid) div = mid;
                count += div / i;
            }
            if (count < k) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(min);
    }
}