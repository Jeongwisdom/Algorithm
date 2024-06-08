import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String star = "*";
        String blank = " ";
        for (int i = 0, j = 2 * n - 1; i < n; i++, j -= 2) {
            sb.append(blank.repeat(i)).append(star.repeat(j)).append("\n");
        }
        System.out.println(sb);
    }
}