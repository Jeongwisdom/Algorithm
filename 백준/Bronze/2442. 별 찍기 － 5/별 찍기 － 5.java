import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String star = "*";
        String blank = " ";
        for (int i = 0; i < n; i++) {
            sb.append(blank.repeat(n - i - 1)).append(star.repeat(i)).append(star).append(star.repeat(i)).append("\n");
        }
        System.out.println(sb);
    }
}