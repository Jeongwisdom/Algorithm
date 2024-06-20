import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            sb.append("*".repeat(i)).append(" ".repeat((n - i) * 2)).append("*".repeat(i)).append("\n");
        }
        StringBuilder answer = new StringBuilder();
        answer.append(sb).append("*".repeat(n * 2)).append(sb.reverse());
        System.out.println(answer);
    }
}