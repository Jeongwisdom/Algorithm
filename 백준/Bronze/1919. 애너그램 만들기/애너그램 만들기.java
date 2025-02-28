import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        for (char c: br.readLine().toCharArray()) {
            arr[c - 97]++;
        }
        for (char c: br.readLine().toCharArray()) {
            arr[c - 97]--;
        }
        
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) answer += Math.abs(arr[i]);
        }
        System.out.println(answer);
    }
}