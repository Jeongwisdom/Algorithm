import java.util.Arrays;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int[] w = new int[10];
        int[] k = new int[10];
        for (int i = 0; i < 10; i++) {
            w[i] = read();
        }
        for (int i = 0; i < 10; i++) {
            k[i] = read();
        }
        
        Arrays.sort(w);
        Arrays.sort(k);
        int sumW = w[9] + w[8] + w[7];
        int sumK = k[9] + k[8] + k[7];
        System.out.println(sumW + " " + sumK);
    }
}