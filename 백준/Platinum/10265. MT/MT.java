import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] ch = new boolean[n + 1];
        int[] visited = new int[n + 1];
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                group(arr, ch, visited, nodes, i);
            }
        }
        
        int[] dp = new int[k + 1];
        for (List<Integer> list: nodes) {
            for (int i = k - 1; i >= 0; i--) {
                for (int num: list) {
                    int sum = num + i;
                    if (sum <= k) {
                        dp[sum] = Math.max(dp[sum], dp[i] + num);
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= k; i++) {
            if (answer < dp[i]) answer = dp[i];
        }
        System.out.println(answer);
    }

    static void group(int[] arr, boolean[] ch, int[] visited, List<List<Integer>> nodes, int id) {
        if (!ch[id]) {
            ch[id] = true;
            group(arr, ch, visited, nodes, arr[id]);
            if (visited[id] == 0) {
                visited[id] = visited[arr[id]];
                List<Integer> list = nodes.get(visited[id] - 1);
                list.add(list.get(list.size() - 1) + 1);
            }
        } else {
            if (visited[id] == 0) {
                List<Integer> list = new ArrayList<>();
                int count = 0;
                int i = nodes.size() + 1;
                while (visited[id] == 0) {
                    visited[id] = i;
                    count++;
                    id = arr[id];
                }
                list.add(count);
                nodes.add(list);
            }
        }
    }
}