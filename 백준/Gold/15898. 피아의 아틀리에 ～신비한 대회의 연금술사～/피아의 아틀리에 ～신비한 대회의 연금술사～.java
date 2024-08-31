import java.io.*;
import java.util.*;

class Main {
    static boolean[] ch;
    static int[][][][] ingredient;
    static char[][][][] ingredientColor;
    static int n, answer = Integer.MIN_VALUE;
    static int[] initX = {0, 0, 1, 1};
    static int[] initY = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new boolean[n];
        ingredient = new int[n][4][4][4];
        ingredientColor = new char[n][4][4][4];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    ingredient[i][0][j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    ingredientColor[i][0][j][k] = st.nextToken().charAt(0);
                }
            }
            rotate(i);
        }

        int[][] arr = new int[5][5];
        char[][] color = new char[5][5];
        for (int i = 0; i < n; i++) {
            ch[i] = true;
            combi(0, i, arr, color);
            ch[i] = false;
        }
        System.out.println(answer);
    }

    static void combi(int cnt, int id, int[][] arr, char[][] color) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    sum += arr[i][j] * getColorNum(color[i][j]);
                }
            }
            if (answer < sum) answer = sum;
            return;
        }

        int[][] quality = new int[5][5];
        char[][] colors = new char[5][5];
        for (int i = 0; i < 4; i++) {
            int initialX = initX[i];
            int initialY = initY[i];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        quality[k][l] = arr[k][l];
                        colors[k][l] = color[k][l];
                    }
                }

                for (int k = initialX; k < initialX + 4; k++) {
                    for (int l = initialY; l < initialY + 4; l++) {
                        quality[k][l] = arr[k][l] + ingredient[id][j][k - initialX][l - initialY];
                        if (quality[k][l] < 0) quality[k][l] = 0;
                        else if (quality[k][l] > 9) quality[k][l] = 9;
                        if (ingredientColor[id][j][k - initialX][l - initialY] != 'W') {
                            colors[k][l] = ingredientColor[id][j][k - initialX][l - initialY];
                        }
                    }
                }

                if (cnt == 2) combi(3, 0, quality, colors);
                else {
                    for (int m = 0; m < n; m++) {
                        if (!ch[m]) {
                            ch[m] = true;
                            combi(cnt + 1, m, quality, colors);
                            ch[m] = false;
                        }
                    }
                }
            }
        }
    }

    static int getColorNum(char c) {
        if (c == 'R') return 7;
        if (c == 'B') return 5;
        if (c == 'G') return 3;
        if (c == 'Y') return 2;
        return 0;
    }

    static void rotate(int id) {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    int dx = rotateX(i, j, k);
                    int dy = rotateY(i, j, k);
                    ingredient[id][i][dx][dy] = ingredient[id][0][j][k];
                    ingredientColor[id][i][dx][dy] = ingredientColor[id][0][j][k];
                }
            }
        }
    }

    static int rotateX(int i, int x, int y) {
        if (i == 1) return y;
        if (i == 2) return 3 - y;
        return 3 - x;
    }

    static int rotateY(int i, int x, int y) {
        if (i == 1) return 3 - x;
        if (i == 2) return x;
        return 3 - y;
    }
}