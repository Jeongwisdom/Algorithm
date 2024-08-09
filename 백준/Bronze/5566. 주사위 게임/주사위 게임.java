import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int pos = 1;
        int i = 1;
        for (; i <= m; i++) {
            pos += Integer.parseInt(br.readLine());
            if (pos >= n) break;
            pos += arr[pos];
            if (pos >= n) break;
        }
        System.out.println(i);
    }
}