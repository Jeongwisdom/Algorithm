import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[9];
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            if (n == 9 || n == 6) {
                arr[6]++;
                int num = arr[6] / 2;
                if (arr[6] % 2 > 0) num++;
                answer = Math.max(answer, num);
            } else {
                arr[n]++;
                answer = Math.max(answer, arr[n]);
            }
        }
        System.out.println(answer);
    }
}