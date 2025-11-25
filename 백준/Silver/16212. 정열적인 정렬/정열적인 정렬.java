import java.util.Arrays;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read();
        boolean minus = false;
        if (n <= 47) {
            minus = true;
            n = 0;
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return minus? -1 * n: n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = read();
        }
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
    }
}