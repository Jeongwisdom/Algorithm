import java.io.*;
import java.math.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        BigInteger a = new BigInteger(split[0]);
        BigInteger b = new BigInteger(split[1]);
        sb.append(a.divide(b)).append("\n").append(a.remainder(b));
        System.out.println(sb);
    }
}