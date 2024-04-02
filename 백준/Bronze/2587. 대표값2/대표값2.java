import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        quickSort(arr, 0, 4);
        StringBuilder sb = new StringBuilder();
        sb.append(sum / 5).append("\n").append(arr[2]);
        System.out.println(sb);
    }
    
    public static void quickSort(int[] arr, int l, int r) {
        int part = partition(arr, l, r);
        if (l < part - 1) quickSort(arr, l, part - 1);
        if (part < r) quickSort(arr, part, r);
    }
    
    public static int partition(int[] arr, int l, int r) {
        int m = (l + r) / 2;
        int povit = arr[m];
        
        while (l <= r) {
            while (arr[l] < povit) l++;
            while (povit < arr[r]) r--;
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