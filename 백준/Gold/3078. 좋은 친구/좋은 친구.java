import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] q = new int[21];
        long answer = 0;
        int r = 0;
        for (; r < k; r++) {
            arr[r] = br.readLine().length();
            answer += q[arr[r]];
            q[arr[r]]++;
        }
        int l = 0;
        while (r < n) {
            arr[r] = br.readLine().length();
            answer += q[arr[r]];
            q[arr[r++]]++;
            q[arr[l++]]--;
        }
        System.out.println(answer);
    }
}