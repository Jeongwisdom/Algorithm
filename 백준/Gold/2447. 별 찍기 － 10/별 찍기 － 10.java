import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[n][n];
        arr[0][0] = true;
        divide(arr, 3, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]) bw.write("*");
                else bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void divide(boolean[][] arr, int count, int n) {
        if (count > n) return;
        int div = count / 3;
        for (int i = 0; i < count; i += div) {
            for (int j = 0; j < count; j += div) {
                if ((i == 0 && j == 0) || (i / div == 1 && j / div == 1)) continue;
                draw(arr, i, j, div);
            }
        }
        divide(arr, count * 3, n);
    }

    public static void draw(boolean[][] arr, int x, int y, int n) {
        for (int i = x, dx = 0; i < x + n; i++, dx++) {
            for (int j = y, dy = 0; j < y + n; j++, dy++) {
                arr[i][j] = arr[dx][dy];
            }
        }
    }
}