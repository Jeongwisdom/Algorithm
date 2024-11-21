import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger i = new BigInteger(br.readLine(), 2);
        System.out.println(i.toString(8));
    }
}