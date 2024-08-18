import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int buffer = 10000000;
        int[] arr = new int[2 * buffer + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(split[i]) + buffer]++;
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            sb.append(arr[Integer.parseInt(split[i]) + buffer]).append(" ");
        }
        System.out.println(sb);
    }
}