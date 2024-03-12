import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        arr[0][0] = '*';
        divide(arr, 3, n);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    public static void divide(char[][] arr, int count, int n) {
        if (count > n) return;
        int div = count / 3;
        for (int i = 0; i < count; i += div) {
            for (int j = 0; j < count; j += div) {
                if (i == 0 && j == 0) continue;
                if (i / div == 1 && j / div == 1) draw(arr, i, j, div, true);
                else draw(arr, i, j, div, false);
            }
        }
        divide(arr, count * 3, n);
    }

    public static void draw(char[][] arr, int x, int y, int n, boolean blank) {
        for (int i = x, dx = 0; i < x + n; i++, dx++) {
            for (int j = y, dy = 0; j < y + n; j++, dy++) {
                if (blank) arr[i][j] = ' ';
                else arr[i][j] = arr[dx][dy];
            }
        }
    }
}