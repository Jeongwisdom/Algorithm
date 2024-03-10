import java.util.*;
import java.io.*;

class Main {
    static boolean flag = false;
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] nine = new boolean[9][10];
    static List<int[]> list = new ArrayList<>();
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    list.add(new int[] {i, j});
                    continue;
                }
                row[i][arr[i][j]] = true;
                col[j][arr[i][j]] = true;
                nine[i / 3 * 3 + j / 3][arr[i][j]] = true;
            }
        }

        BF(0);
    }

    public static void BF(int count) {
        if (!flag) {
            if (count == list.size()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(arr[i][j]).append(" ");
                    }
                    sb.append("\n");
                }
                System.out.print(sb);
                flag = true;
            } else {
                int[] point = list.get(count);
                int x = point[0];
                int y = point[1];
                for (int i = 1; i <= 9; i++) {
                    if (!row[x][i] && !col[y][i] && !nine[x / 3 * 3 + y / 3][i]) {
                        row[x][i] = true;
                        col[y][i] = true;
                        nine[x / 3 * 3 + y / 3][i] = true;
                        arr[x][y] = i;
                        BF(count + 1);
                        row[x][i] = false;
                        col[y][i] = false;
                        nine[x / 3 * 3 + y / 3][i] = false;
                        arr[x][y] = 0;
                    }
                }
            }
        }
    }
}