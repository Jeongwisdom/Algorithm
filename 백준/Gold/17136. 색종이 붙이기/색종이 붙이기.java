import java.io.*;
import java.util.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static int[] confetti = new int[5];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[10][10];
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) confetti[i] = 5;
        DFS(0, 0, 0);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    static int getSquareSize(int x, int y) {
        int num = 1;
        while (num <= 4) {
            for (int i = 0; i <= num; i++) {
                if (x + num >= 10 || y + i >= 10 || arr[x + num][y + i] == 0) return num - 1;
                if (x + i >= 10 || y + num >= 10 ||arr[x + i][y + num] == 0) return num - 1;
            }
            num++;
        }
        return num - 1;
    }

    static void DFS(int x, int y, int count) {
        if (answer == count) return;
        if (x == 9 && y == 10) {
            answer = count;
            return;
        }
        if (y == 10) {
            x += 1;
            y = 0;
        }
        if (arr[x][y] == 1) {
            int size = getSquareSize(x, y);
            attach(size, x, y);
            while (size >= 0) {
                if (confetti[size] > 0) {
                    confetti[size]--;
                    DFS(x, y + 1,count + 1);
                    confetti[size]++;
                }
                detach(size, x, y);
                size--;
            }
        } else DFS(x, y + 1, count);
    }

    static void attach(int num, int x, int y) {
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                arr[x + i][y + j] = 0;
            }
        }
    }
    
    static void detach(int num, int x, int y) {
        for (int i = 0; i <= num; i++) {
            arr[x + num][y + i] = 1;
            arr[x + i][y + num] = 1;
        }
    }
}