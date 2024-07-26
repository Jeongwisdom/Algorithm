import java.io.*;
import java.util.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static boolean[] ch = new boolean[4];
    static double[][] dis = new double[4][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[4][2];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dis[i][j] = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
            }
        }

        ch[0] = true;
        DFS(0, 0, 0.0);
        System.out.println(answer);
    }

    static void DFS(int count, int ex, double sum) {
        if (count == 3) {
            if (answer > (int) sum) answer = (int) sum;
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (!ch[i]) {
                ch[i] = true;
                DFS(count + 1, i, sum + dis[ex][i]);
                ch[i] = false;
            }
        }
    }
}