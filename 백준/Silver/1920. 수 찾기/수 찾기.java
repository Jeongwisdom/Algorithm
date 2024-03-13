import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[2][];
        for (int i = 0; i < 2; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quickSort(arr[0], 0, arr[0].length - 1);
        for (int i = 0; i < arr[1].length; i++) {
            if (check(arr[0], arr[1][i])) bw.write("1\n");
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