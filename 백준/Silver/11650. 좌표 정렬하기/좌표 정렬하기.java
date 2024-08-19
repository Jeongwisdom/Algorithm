import java.io.*;
import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read();
        boolean minus = false;
        if (n < 48) {
            minus = true;
            n = 0;
        } else n &= 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -1 * n: n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }
        Arrays.sort(arr, (a1, a2) -> {
            if (a1[0] == a2[0]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
