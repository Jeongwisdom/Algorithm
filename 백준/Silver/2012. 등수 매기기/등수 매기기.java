import java.io.*;

class Main {
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
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