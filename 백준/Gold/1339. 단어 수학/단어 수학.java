import java.io.*;
import java.util.*;

class Main {
    static int n, answer = 0;
    static String[] arr;
    static Map<Character, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            int pow = (int) Math.pow(10, arr[i].length() - 1);
            for (int j = 0; j < arr[i].length(); j++, pow /= 10) {
                char c = arr[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + pow);
            }
        }
        
        List<Character> keySet = new ArrayList<>(map.keySet());
        keySet.sort((k1, k2) -> map.get(k2) - map.get(k1));
        int num = 9;
        int answer = 0;
        for (char c: keySet) {
            answer += map.get(c) * num--;
        }
        System.out.println(answer);
    }
}