import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int r = 1;
        long answer = Long.MAX_VALUE;
        for (int l = 0; l < N; l++) {
            while (r < N && arr[r] - arr[l] < M) r++;
            if (r == N) break;
            answer = Math.min(answer, arr[r] - arr[l]);
        }
        System.out.println(answer);
    }
}