import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>> person = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            person.put(i, new HashSet<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            person.get(x).add(y);
            person.get(y).add(x);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] ch = new boolean[n + 1];
        ch[a] = true;
        q.offer(a);
        int answer = 0;
        loop:
        while (!q.isEmpty()) {
            int len = q.size();
            answer++;
            for (int i = 0; i < len; i++) {
                int num1 = q.poll();
                for (int num2: person.get(num1)) {
                    if (!ch[num2]) {
                        ch[num2] = true;
                        q.offer(num2);
                        if (num2 == b) break loop;
                    }
                }
            }
        }
        if (q.isEmpty()) answer = -1;
        System.out.println(answer);
    }
}