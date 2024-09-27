import java.math.BigInteger;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        if (n == m) System.out.println(1);
        else {
            BigInteger[] arr = new BigInteger[n + 1];
            arr[1] = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1].multiply(new BigInteger(String.valueOf(i)));
            }
            BigInteger answer = arr[n].divide(arr[m].multiply(arr[(n - m)]));
            System.out.println(answer);
        }
    }
}