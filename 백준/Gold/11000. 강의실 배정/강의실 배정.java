import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        quickSort(arr, 0, n - 1);
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= arr[i][0]) pq.poll();
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());
    }
    
    public static void quickSort(int[][] arr, int l, int r) {
        int part = partition(arr, l, r);
        if (l < part - 1) quickSort(arr, l, part - 1);
        if (r > part) quickSort(arr, part, r);
    }
    
    public static int partition(int[][] arr, int l, int r) {
        int m = (l + r) / 2;
        int pivot = arr[m][0];
        while (l <= r) {
            while (arr[l][0] < pivot) l++;
            while (arr[r][0] > pivot) r--;
            if (l <= r) {
                int[] tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
        
        return l;
    }
}