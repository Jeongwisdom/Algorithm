import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, n - 1);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (check(arr, Integer.parseInt(st.nextToken()))) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.flush();
    }

    public static boolean check(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (num == arr[m]) return true;
            else if (num < arr[m]) r = m - 1;
            else if (num > arr[m]) l = m + 1;
        }
        return false;
    }

    public static void quickSort(int[] arr, int l, int r) {
        int part = partition(arr, l, r);
        if (l < part - 1) quickSort(arr, l, part - 1);
        if (r > part) quickSort(arr, part, r);
    }

    public static int partition(int[] arr, int l, int r) {
        int m = (l + r) / 2;
        int pivot = arr[m];

        while (l <= r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
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