import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] crystal = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            crystal[i][0] = Integer.parseInt(st.nextToken());
            crystal[i][1] = Integer.parseInt(st.nextToken());
        }
        TreeMap<Integer, Integer> bag = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            int m = Integer.parseInt(br.readLine());
            bag.put(m, bag.getOrDefault(m, 0) + 1);
        }
        
        Arrays.sort(crystal, (c1, c2) -> {
            if (c2[1] == c1[1]) return c1[0] - c2[0];
            return c2[1] - c1[1];
        });
        long answer = 0;
        int i = 0;
        while (k > 0 && i < n) {
            Integer key = bag.ceilingKey(crystal[i][0]);
            if (key != null) {
                if (bag.get(key) > 1) bag.put(key, bag.get(key) - 1);
                else bag.remove(key);
                answer += crystal[i][1];
                k--;
            }
            i++;
        }
        System.out.println(answer);
    }
}