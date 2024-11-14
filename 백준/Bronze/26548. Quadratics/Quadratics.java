import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] split;
        double a, b, c, d, e, f;
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            a = Double.parseDouble(split[0]);
            b = Double.parseDouble(split[1]);
            c = Double.parseDouble(split[2]);
            d = -1 * b;
            e = Math.sqrt(b * b - 4 * a * c);
            f = 2 * a;
            sb.append(String.format("%.3f", (d + e) / f)).append(", ").append(String.format("%.3f", (d - e) / f)).append("\n");
        }
        System.out.println(sb);
    }
}