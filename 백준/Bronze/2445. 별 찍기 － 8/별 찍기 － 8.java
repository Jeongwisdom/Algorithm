import java.io.*;

class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            draw(i);
        }
        for (int i = n - 1; i >= 1; i--) {
            draw(i);
        }
        System.out.println(sb);
    }

    static void draw(int i) {
        sb.append("*".repeat(i)).append(" ".repeat((n - i) * 2)).append("*".repeat(i)).append("\n");
    }
}