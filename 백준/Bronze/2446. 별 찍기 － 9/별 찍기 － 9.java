import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            draw(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            draw(i);
        }
        System.out.println(sb);
    }
    
    static void draw(int i) {
        sb.append(" ".repeat(i)).append("*".repeat(2 * (n - i) - 1)).append("\n");
    }
}