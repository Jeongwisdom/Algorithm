import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num % 2 == 0) sb.append(num).append(" is even").append("\n");
            else sb.append(num).append(" is odd").append("\n");
        }
        System.out.println(sb);
    }
}