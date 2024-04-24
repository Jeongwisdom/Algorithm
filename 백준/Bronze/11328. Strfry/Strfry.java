import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr1 = new int[26];
            String str1 = st.nextToken();
            for (int j = 0; j < str1.length(); j++) {
                arr1[str1.charAt(j) - 'a']++;
            }
            int[] arr2 = new int[26];
            String str2 = st.nextToken();
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