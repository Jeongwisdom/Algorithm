import java.io.*;
import java.util.*;

class Main {
    static int answer = 26;
    static int[] confetti = {5, 5, 5, 5, 5};
    static int[][] arr = new int[10][10];

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = read();
            }
        }
        DFS(0, 0, 0);
        if (answer == 26) answer = -1;
        System.out.println(answer);
    }

    static boolean getSquareSize(int x, int y, int len) {
        if (x + len > 9 || y + len > 9) return false;
        for (int i = x; i <= x + len; i++) {
            for (int j = y; j <= y + len; j++) {
                if (arr[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void DFS(int x, int y, int count) {
        if (answer == count) return;
        while (x < 10 && arr[x][y] == 0) {
            while (y < 10 && arr[x][y] == 0) {
                y++;
            }
            if (y == 10) {
                x++;
                y = 0;
            }
        }
        if (x == 10) {
            answer = count;
            return;
        }
        
        int size = 0;
        for (int i = 4; i > 0; i--) {
            if (getSquareSize(x, y, i)) {
                size = i;
                break;
            }
        }
        attach(size, x, y);
        while (size >= 0) {
            if (confetti[size] > 0) {
                confetti[size]--;
                DFS(x, y,count + 1);
                confetti[size]++;
            }
            detach(size, x, y);
            size--;
        }
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