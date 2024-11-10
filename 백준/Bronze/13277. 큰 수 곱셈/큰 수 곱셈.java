import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        BigInteger a = new BigInteger(split[0]);
        BigInteger b = new BigInteger(split[1]);
        System.out.println(a.multiply(b));
    }
}