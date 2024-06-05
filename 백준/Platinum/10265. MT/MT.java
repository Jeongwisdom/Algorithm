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
        Set<Integer>[] visited = new HashSet[n + 1];
        List<Set<Integer>> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                group(arr, ch, visited, nodes, i);
            }
        }
        
        int[] dp = new int[k + 1];
        for (Set<Integer> set: nodes) {
            for (int i = k - 1; i >= 0; i--) {
                for (int num: set) {
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

    static void group(int[] arr, boolean[] ch, Set<Integer>[] visited, List<Set<Integer>> nodes, int id) {
        if (!ch[id]) {
            ch[id] = true;
            group(arr, ch, visited, nodes, arr[id]);
            if (visited[id] == null) {
                Set<Integer> set = visited[arr[id]];
                visited[id] = set;
                Set<Integer> toAdd = new HashSet<>();
                for (int num : set) {
                    toAdd.add(num + 1);
                }
                set.addAll(toAdd);
            }
        } else {
            if (visited[id] == null) {
                Set<Integer> set = new HashSet<>();
                int count = 0;
                while (visited[id] == null) {
                    visited[id] = set;
                    count++;
                    id = arr[id];
                }
                set.add(count);
                nodes.add(set);
            }
        }
    }
}