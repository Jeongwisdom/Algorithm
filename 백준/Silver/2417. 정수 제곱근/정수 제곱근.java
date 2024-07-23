import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long answer = (long) Math.sqrt(n);
        if (answer * answer < n) answer++;
        System.out.println(answer);
    }
}