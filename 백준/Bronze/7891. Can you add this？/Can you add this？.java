import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] split;
        int a, b;
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}