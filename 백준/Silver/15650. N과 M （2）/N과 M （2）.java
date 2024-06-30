import java.io.*;

class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        DFS(new int[m], 1, 0);
        System.out.println(sb);
    }
    
    static void DFS(int[] arr, int id, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = id; i <= n; i++) {
                arr[count] = i;
                DFS(arr, i + 1, count + 1);
            }
        }
    }
}