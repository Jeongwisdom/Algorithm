import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] number, arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        number = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[m];
        quickSort(0, n - 1);
        DFS(0);
        System.out.println(sb);
    }

    static void quickSort(int l, int r) {
        int part = partition(l, r);
        if (l < part - 1) quickSort(l, part - 1);
        if (part < r) quickSort(part, r);
    }

    static int partition(int l, int r) {
        int mid = (l + r) / 2;
        int pivot = number[mid];
        while (l <= r) {
            while (number[l] < pivot) l++;
            while (pivot < number[r]) r--;
            if (l <= r) {
                int tmp = number[l];
                number[l] = number[r];
                number[r] = tmp;
                l++;
                r--;
            }
        }
        return l;
    }

    static void DFS(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[count] = number[i];
            DFS(count + 1);
        }
    }
}