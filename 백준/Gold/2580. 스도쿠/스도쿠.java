import java.util.*;
import java.io.*;

class Main {
    static boolean flag = false;
    static List<int[]> list = new ArrayList<>();
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) list.add(new int[] {i, j});
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
                    if (checkRow(x, y, i) && checkCol(x, y, i) && checkNine(x, y, i)) {
                        arr[x][y] = i;
                        BF(count + 1);
                        arr[x][y] = 0;
                    }
                }
            }
        }
    }

    public static boolean checkRow(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == num) return false;
        }

        return true;
    }
    
    public static boolean checkCol(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == num) return false;
        }

        return true;
    }
    
    public static boolean checkNine(int x, int y, int num) {
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (arr[i][j] == num) return false;
            }
        }

        return true;
    }
}