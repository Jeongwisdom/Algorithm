import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            y += calculate(30, 10, num);
            m += calculate(60, 15, num);
        }
        if (y == m) System.out.println("Y M " + y);
        else if (y < m) System.out.println("Y " + y);
        else System.out.println("M " + m);
    }
    
    public static int calculate(int time, int money, int num) {
        return money * (num / time + 1);
    }
}