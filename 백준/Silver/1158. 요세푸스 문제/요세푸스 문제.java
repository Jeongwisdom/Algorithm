import java.io.*;
import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write('<');
        int id = 0;
        while (list.size() > 1) {
            id = (id + k - 1) % list.size();
            bw.write(String.valueOf(list.remove(id)));
            bw.write(", ");
        }

        bw.write(String.valueOf(list.remove(0)));
        bw.write('>');
        bw.flush();
    }
}