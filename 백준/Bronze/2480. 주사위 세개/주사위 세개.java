import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int a;
        for (int i = 0; i < 3; i++) {
            a = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 3) {
                sum = entry.getKey() * 1000 + 10000;
                break;
            } else if (entry.getValue() == 2) {
                sum = entry.getKey() * 100 + 1000;
                break;
            } else {
                sum = Math.max(sum, entry.getKey() * 100);
            }
        }
        System.out.print(sum);
    }
}