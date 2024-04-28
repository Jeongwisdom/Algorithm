import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[9];
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 9 || num == 6) {
                arr[6]++;
                answer = Math.max(answer, (int) Math.ceil(arr[6] / 2.0));
            } else {
                arr[num]++;
                answer = Math.max(answer, arr[num]);
            }
        }
        System.out.println(answer);
    }
}