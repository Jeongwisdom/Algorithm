import java.util.*;

class Main {
    static int N, M;
    static int[] arr, sort;

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
        N = read();
        sort = new int[N];
        for (int i = 0; i < N; i++) {
            sort[i] = read();
        }
        M = read();
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = read();
        }
        Arrays.sort(sort);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(i)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int id) {
        int l = 0, r = N - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[id] < sort[mid]) r = mid - 1;
            else if (arr[id] > sort[mid]) l = mid + 1;
            else return 1;
        }
        return 0;
    }
}