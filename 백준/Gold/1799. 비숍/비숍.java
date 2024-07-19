import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int n, even = 0, odd = 0;
    static List<int[]> oddList = new ArrayList<>();
    static List<int[]> evenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if ((i + j) % 2 == 0) evenList.add(new int[] {i, j});
                else oddList.add(new int[] {i, j});
            }
        }

        DFS(0, 0, 0);
        DFS(0, 0, 1);
        System.out.println(even + odd);
    }

    static void DFS(int id, int count, int remain) {
        if (remain == 0 && id == evenList.size()) {
            if (even < count) even = count;
            return;
        }
        if (remain == 1 && id == oddList.size()) {
            if (odd < count) odd = count;
            return;
        }

        int[] p;
        if (remain == 0) p = evenList.get(id);
        else p = oddList.get(id);
        if (arr[p[0]][p[1]] == 1 && check(p[0], p[1])) {
            arr[p[0]][p[1]] = 2;
            DFS(id + 1, count + 1, remain);
            arr[p[0]][p[1]] = 1;
        }
        DFS(id + 1, count, remain);
    }

    static boolean check(int x, int y) {
        for (int i = 0; x >= i && y >= i; i++) {
            if (arr[x - i][y - i] == 2) return false;
        }
        for (int i = 0; x >= i && y + i < n; i++) {
            if (arr[x - i][y + i] == 2) return false;
        }
        for (int i = 0; x + i < n && y >= i; i++) {
            if (arr[x + i][y - i] == 2) return false;
        }
        for (int i = 0; x + i < n && y + i < n; i++) {
            if (arr[x + i][y + i] == 2) return false;
        }
        return true;
    }
}