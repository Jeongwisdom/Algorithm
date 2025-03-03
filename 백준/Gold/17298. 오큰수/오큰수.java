import java.io.*;

class Main {
    static int c, n;

    static int read() throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = read();

        int MAX = 1000000 << 3;
        char[] buffer = new char[MAX];
        int[] stack = new int[N];
        int num, bufferId = MAX, id = -1;
        for (int i = N - 1; i >= 0; i--) {
            while (id >= 0) {
                if (numbers[i] < stack[id]) break;
                id--;
            }

            if (id >= 0) {
                num = stack[id];
                while (num > 0) {
                    buffer[--bufferId] = (char) (num % 10 + 48);
                    num /= 10;
                }
            } else {
                buffer[--bufferId] = 49;
                buffer[--bufferId] = 45;
            }
            buffer[--bufferId] = 32;
            stack[++id] = numbers[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(buffer, ++bufferId, MAX - bufferId);
        bw.flush();
    }
}