import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        System.out.println(Math.abs(a - b));
    }
}