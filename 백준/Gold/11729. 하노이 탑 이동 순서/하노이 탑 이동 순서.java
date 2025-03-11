import java.io.*;

class Main {
    static char[] buffer;
    static int id = 0;

    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = (1 << n) - 1;
        buffer = new char[num << 4];
        bw.write(String.valueOf(num));
        bw.write('\n');
        hanoi(n, 1, 3);
        bw.write(buffer, 0, id);
        bw.flush();
    }

    static void hanoi(int n, int a, int b) {
        if (n == 0) return;
        hanoi(n - 1, a, 6 - a - b);
        buffer[id++] = (char) (a + '0');
        buffer[id++] = ' ';
        buffer[id++] = (char) (b + '0');
        buffer[id++] = '\n';
        hanoi(n - 1, 6 - a - b, b);
    }
}