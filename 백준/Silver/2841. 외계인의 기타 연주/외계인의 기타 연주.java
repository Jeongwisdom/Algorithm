import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int p = read();
        int[][] arr = new int[7][p + 1];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int line = read();
            int num = read();
            while (arr[line][0] != 0 && arr[line][arr[line][0]] > num) {
                arr[line][0]--;
                answer++;
            }
            if (arr[line][0] == 0 || arr[line][arr[line][0]] < num) {
                arr[line][0]++;
                arr[line][arr[line][0]] = num;
                answer++;
            }
        }
        System.out.println(answer);
    }
}