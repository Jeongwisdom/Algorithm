import java.util.*;
import java.io.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] arr = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            int w = read();
            arr[i] = new int[w];
            for (int j = 0; j < w; j++) {
                arr[i][j] = read();
            }
        }
        
        int[] work = new int[m + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (DFS(arr, work, new boolean[m + 1], i)) answer++;
        }
        System.out.println(answer);
    }

    static boolean DFS(int[][] arr, int[] work, boolean[] ch, int id) {
        for (int i = 0; i < arr[id].length; i++) {
            int w = arr[id][i];
            if (!ch[w]) {
                ch[w] = true;
                if (work[w] == 0 || DFS(arr, work, ch, work[w])) {
                    work[w] = id;
                    return true;
                }
            }
        }
        return false;
    }
}