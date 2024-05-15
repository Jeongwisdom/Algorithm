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
        int l = 0 - k;
        long answer = 0;
        for (int r = 0; r < n; r++, l++) {
            arr[r] = br.readLine().length();
            answer += q[arr[r]];
            q[arr[r]]++;
            if (l >= 0) q[arr[l]]--;
        }
        System.out.println(answer);
    }
}