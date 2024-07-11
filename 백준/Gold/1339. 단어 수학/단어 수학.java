import java.io.*;
import java.util.*;

class Main {
    static int n, answer = 0;
    static String[] arr;
    static int[] comb = new int[26];
    static Map<Character, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, arr[i].length() - j - 1));
            }
        }
        
        List<Character> keySet = new ArrayList<>(map.keySet());
        keySet.sort((k1, k2) -> map.get(k2) - map.get(k1));
        int num = 9;
        for (char c: keySet) {
            comb[c - 'A'] = num--;
        }
        DFS(0, 0);
        System.out.println(answer);
    }
    
    static void DFS(int count, int sum) {
        if (count == n) {
            if (answer < sum) answer = sum;
            return;
        }
        int num = 0;
        for (int i = 0; i < arr[count].length(); i++) {
            char c = arr[count].charAt(i);
            num = num * 10 + comb[c - 'A'];
        }
        DFS(count + 1, sum + num);
    }
}