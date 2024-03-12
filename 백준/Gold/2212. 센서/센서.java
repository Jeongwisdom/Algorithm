import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (k >= n) {
            System.out.println(0);
            System.exit(0);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1);
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        quickSort(diff, 0, n - 2);
        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
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