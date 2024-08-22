import java.io.*;

class Main {
    static int length = 2;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[50];
        arr[0] = n;
        for (int i = n / 2; i <= n; i++) {
            arr[1] = i;
            DFS(2);
        }
        System.out.println(length);
        System.out.println(sb);
    }

    static void DFS(int cnt) {
        int num = arr[cnt - 2] - arr[cnt - 1];
        if (num < 0) {
            if (length < cnt) {
                length = cnt;
                sb = new StringBuilder();
                for (int i = 0; i <= cnt; i++) {
                    sb.append(arr[i]).append(" ");
                }
            }
            return;
        }
        arr[cnt] = num;
        DFS(cnt + 1);
    }
}