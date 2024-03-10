import java.util.*;
import java.io.*;

class Main {
    static boolean flag = false;
    static List<boolean[]> row = new ArrayList<>();
    static List<boolean[]> col = new ArrayList<>();
    static List<int[]> list = new ArrayList<>();
    static Map<String, boolean[]> map = new HashMap<>();
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

        for (int i = 0; i < 9; i++) {
            boolean[] r = new boolean[10];
            boolean[] c = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] != 0) r[arr[i][j]] = true;
                if (arr[j][i] != 0) c[arr[j][i]] = true;
            }
            row.add(r);
            col.add(c);
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                map.put(i / 3 + " " + j / 3, checkNine(i, j));
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
                boolean[] r = row.get(x);
                boolean[] c = col.get(y);
                boolean[] n = map.get(x / 3 + " " + y / 3);
                for (int i = 1; i <= 9; i++) {
                    if (!r[i] && !c[i] && !n[i]) {
                        r[i] = true;
                        c[i] = true;
                        n[i] = true;
                        arr[x][y] = i;
                        BF(count + 1);
                        r[i] = false;
                        c[i] = false;
                        n[i] = false;
                        arr[x][y] = 0;
                    }
                }
            }
        }
    }

    public static boolean[] checkNine(int x, int y) {
        boolean[] ch = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (!ch[arr[i][j]]) ch[arr[i][j]] = true;
            }
        }

        return ch;
    }
}