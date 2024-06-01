import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] ch = new boolean[n + 1];
            boolean[] visited = new boolean[n + 1];
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) answer += DFS(arr, ch, visited, i);
            }
            sb.append(n - answer).append("\n");
        }
        System.out.println(sb);
    }
    
    static int DFS(int[] arr, boolean[] ch, boolean[] visited, int id) {
        int count = 0;
        if (!ch[id]) {
            ch[id] = true;
            count += DFS(arr, ch, visited, arr[id]);
            visited[id] = true;
        } else {
            while (!visited[id]) {
                visited[id] = true;
                count++;
                id = arr[id];
            }
        }
        return count;
    }
}