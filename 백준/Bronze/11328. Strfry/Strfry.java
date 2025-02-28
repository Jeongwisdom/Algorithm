import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            String[] split = br.readLine().split(" ");
            for (char c: split[0].toCharArray()) {
                arr[c - 97]++;
            }
            
            for (char c: split[1].toCharArray()) {
                arr[c - 97]--;
            }

            boolean ch = true;
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
                    ch = false;
                    break;
                }
            }

            if (ch) sb.append("Possible");
            else sb.append("Impossible");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}