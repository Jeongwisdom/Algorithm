import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int r1 = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);
        System.out.println(2 * s - r1);
    }
}