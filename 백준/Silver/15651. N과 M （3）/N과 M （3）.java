import java.io.*;

class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        arr = new int[m];
        DFS(0);
        System.out.println(sb);
    }
    
    static void DFS(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                arr[count] = i;
                DFS(count + 1);
            }
        }
    }
}