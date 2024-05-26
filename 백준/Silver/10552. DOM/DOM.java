import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int p = read();
        int[] arr = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int favorite = read();
            int hate = read();
            if (arr[hate] == 0) arr[hate] = favorite;
        }
        int answer = 0;
        boolean[] ch = new boolean[m + 1];
        while (arr[p] > 0) {
            if (ch[p]) {
                answer = -1;
                break;
            }
            ch[p] = true;
            p = arr[p];
            answer++;
        }
        System.out.println(answer);
    }
}