import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (q.contains(arr[i])) continue;
            if (q.size() >= n) {
                Set<Integer> set = new HashSet<>();
                int count =0;
                for (int j = i + 1; j < k; j++) {
                    if (count == n - 1) break;
                    if (!set.contains(arr[j]) && q.contains(arr[j])) {
                        q.remove(arr[j]);
                        q.offer(arr[j]);
                        set.add(arr[j]);
                        count++;
                    }
                }
                q.poll();
                answer++;
            }
            q.offer(arr[i]);
        }
        System.out.println(answer);
    }
}