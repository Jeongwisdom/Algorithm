import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] s = new int[n + 2];
        int answer = 0;
        for (int i = 1, idx = 0; i < n + 2; i++) {
            while (idx > 0 && arr[i] <= arr[s[idx]]) {
                int height = arr[s[idx]];
                idx--;
                answer = Math.max(answer, height * (i - (s[idx] + 1)));
            }
            s[++idx] = i;
        }
        System.out.println(answer);
    }
}