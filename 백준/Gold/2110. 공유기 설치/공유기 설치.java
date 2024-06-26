import java.util.Arrays;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int c = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);
        
        int min = 1;
        int max = arr[n - 1] - arr[0];
        int mid;
        while (min <= max) {
            mid = (min + max) >> 1;
            int num = 1;
            int ex = arr[0];
            for (int i = 1; i < n; i++) {
                if (arr[i] - ex >= mid) {
                    ex = arr[i];
                    num++;
                }
            }
            if (num >= c) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(max);
    }
}