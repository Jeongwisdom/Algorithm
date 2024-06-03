import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String blank = " ";
        String star = "*";
        for (int i = 0; i < n; i++) {
            sb.append(blank.repeat(i)).append(star.repeat(n - i)).append("\n");
        }
        System.out.println(sb);
    }
}