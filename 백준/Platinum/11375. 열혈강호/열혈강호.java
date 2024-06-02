import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new int[w];
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] ch;
        int[] work = new int[m + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            ch = new boolean[m + 1];
            if (DFS(arr, work, ch, i)) answer++;
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