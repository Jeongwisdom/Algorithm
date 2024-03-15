import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(String.valueOf(check(arr, 0, n - 1)));
            bw.write("\n");
        }
        bw.flush();
    }
    
    public static long check(int[] arr, int l, int r) {
        if (l == r) return arr[l];
        
        int mid = (l + r) / 2;
        int lp = mid;
        int rp = mid + 1;
        int h = Math.min(arr[lp], arr[rp]);
        long answer = Math.max(2l * h, Math.max(check(arr, l, lp), check(arr, rp, r)));
        while (l < lp || rp < r) {
            int lh = -1;
            int rh = -1;
            if (l < lp) lh = arr[lp - 1];
            if (rp < r) rh = arr[rp + 1];
            
            if (lh < rh) h = Math.min(h, arr[++rp]);
            else h = Math.min(h, arr[--lp]);
            answer = Math.max(answer, (rp - lp + 1l) * h);
        }
        return answer;
    }
}