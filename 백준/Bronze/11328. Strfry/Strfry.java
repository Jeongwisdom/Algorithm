import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int[] arr1 = new int[26];
            String str1 = split[0];
            for (int j = 0; j < str1.length(); j++) {
                arr1[str1.charAt(j) - 'a']++;
            }
            int[] arr2 = new int[26];
            String str2 = split[1];
            for (int j = 0; j < str2.length(); j++) {
                arr2[str2.charAt(j) - 'a']++;
            }
            boolean ch = true;
            for (int j = 0; j < 26; j++) {
                if (arr1[j] != arr2[j]) {
                    ch = false;
                    break;
                }
            }
            if (ch) sb.append("Possible\n");
            else sb.append("Impossible\n");
        }
        System.out.println(sb);
    }
}