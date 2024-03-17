import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String str = br.readLine();
        for (char c: str.toCharArray()) {
            if (c <= 'Z') alpha[c - 'A']++;
            else alpha[c - 'a']++;
        }
        char answer = '?';
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (max < alpha[i]) {
                max = alpha[i];
                answer = (char) (i + 'A');
            } else if (max == alpha[i]) answer = '?';
        }
        System.out.println(answer);
    }
}