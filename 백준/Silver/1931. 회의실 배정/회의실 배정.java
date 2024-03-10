import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        int time = 0;
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (time <= arr[i][0]) {
                answer++;
                time = arr[i][1];
            }
        }
        System.out.println(answer);
    }
    
    public static void quickSort(int[][] arr, int l, int r) {
        int part = partition(arr, l, r);
        if (l < part - 1) quickSort(arr, l, part - 1);
        if (r > part) quickSort(arr, part, r);
    }
    
    public static int partition(int[][] arr, int l, int r) {
        int m = (l + r) / 2;
        int pivot = arr[m][1];
        
        while (l <= r) {
            while (arr[l][1] < pivot) l++;
            while (arr[r][1] > pivot) r--;
            if (l <= r) {
                if (arr[l][1] != arr[r][1] || arr[l][0] > arr[r][0]) {
                    int[] tmp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = tmp;
                }
                l++;
                r--;
            }
        }
        
        return l;
    }
}