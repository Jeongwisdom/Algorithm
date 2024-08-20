import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i > 0; i--) {
            answer += i - search(arr[i], i - 1);
        }
        System.out.println(answer);
    }

    static int search(int number, int id) {
        int l = 0;
        int r = id;
        int target = (int) Math.ceil(number * 0.9);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= arr[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}