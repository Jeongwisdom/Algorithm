import java.util.*;

class Main {
    static int n;
    static int[] arr;

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        long answer = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i > 0; i--) {
            answer += i - search(arr[i], i - 1);
        }
        System.out.println(answer);
    }

    static int search(int number, int id) {
        int l = 0;
        int r = id;
        int target = (int) Math.ceil(number * 0.9);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= arr[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}