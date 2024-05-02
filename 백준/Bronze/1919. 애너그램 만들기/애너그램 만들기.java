import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int[] arr1 = count(s1);
        String s2 = br.readLine();
        int[] arr2 = count(s2);
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println(answer);
    }
    
    static int[] count(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}