import java.io.*;

class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            draw(i);
        }
        for (int i = 1; i < n; i++) {
            draw(i);
        }
        System.out.println(sb);
    }
    
    static void draw(int i) {
        sb.append(" ".repeat(i)).append("*".repeat(2 * (n - i) - 1)).append("\n");
    }
}