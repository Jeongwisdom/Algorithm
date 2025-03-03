import java.io.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num, n = read(), max = 0, id = 0;
        int[][] stack = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            num = read();
            if (max < num) {
                bw.write("0 ");
                max = num;
            } else {
                while (stack[id][1] < num) id--;
                bw.write(String.valueOf(stack[id][0]));
                bw.write(" ");
            }
            stack[id + 1][0] = i;
            stack[id + 1][1] = num;
            id++;
        }
        bw.flush();
    }
}