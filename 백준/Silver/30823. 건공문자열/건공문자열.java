import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]) - 1;
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder answer = new StringBuilder();
        if ((n - k) % 2 == 1) {
            answer.append(sb.substring(k)).append(new StringBuilder(sb.substring(0, k)).reverse());
        } else {
            answer.append(sb.substring(k)).append(sb.substring(0, k));
        }
        System.out.println(answer);
    }
}