import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void quickSort(int[] arr, int l, int r) {
        int part = partition(arr, l, r);
        if (l < part - 1) quickSort(arr, l, part - 1);
        if (r > part) quickSort(arr, part, r);
    }
    
    public static int partition(int[] arr, int l, int r) {
        int m = (l + r) / 2;
        int mid = arr[m];
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