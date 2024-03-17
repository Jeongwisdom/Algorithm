import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        String str = br.readLine();
        for (char c: str.toUpperCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char answer = '?';
        int max = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                answer = entry.getKey();
            } else if (max == entry.getValue()) answer = '?';
        }
        System.out.println(answer);
    }
}