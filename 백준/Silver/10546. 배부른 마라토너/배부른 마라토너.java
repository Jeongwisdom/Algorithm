import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            map.put(str, map.get(str) - 1);
        }
        for (String str: map.keySet()) {
            if (map.get(str) == 1) System.out.println(str);
        }
    }
}