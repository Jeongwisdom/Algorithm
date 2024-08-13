import java.io.*;

class Main {
    static int[] arr;
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c =System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        int n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        quickSort(0, n - 1);
        
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.abs(arr[i] - (i + 1));
        }
        System.out.println(answer);
    }
    
    static void quickSort(int l, int r) {
        int part = partition(l, r);
        if (l < part - 1) quickSort(l, part - 1);
        if (part < r) quickSort(part, r);
    }
    
    static int partition(int l, int r) {
        int mid = arr[(l + r) / 2];
        while (l <= r) {
            while (arr[l] < mid) l++;
            while (mid < arr[r]) r--;
            if (l <= r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
        return l;
    }
}