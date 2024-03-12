import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        divide((int) Math.pow(2, n) / 2, r, c);
        System.out.println(answer);
    }
    
    public static void divide(int n, int r, int c) {
        if (n == 0) return;
        int row = 0;
        int col = 0;
        if (r >= n) row += 2;
        if (c >= n) col += 1;
        
        answer += n * n * (row + col);
        divide(n / 2, r - n * row / 2, c - n * col);
    }
}