import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int half = (int) Math.pow(2, n) / 2;
        int answer = 0;
        while (half > 0) {
            int row = 0, col = 0;
            if (r >= half) row += 2;
            if (c >= half) col += 1;
            answer += half * half * (row + col);
            r -= half * row / 2;
            c -= half * col;
            half /= 2;
        }
        System.out.println(answer);
    }
}