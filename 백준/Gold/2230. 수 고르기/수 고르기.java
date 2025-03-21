import java.util.*;

class Main {
    static int read() throws Exception {
        boolean minus = false;
        int c, n = System.in.read();
        if (n == 45) {
            minus = true;
            n = System.in.read();
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }

    public static void main(String[] args) throws Exception {
        int N = read(), M = read();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
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