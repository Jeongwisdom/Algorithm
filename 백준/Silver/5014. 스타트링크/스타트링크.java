import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int F = read(), S = read(), G = read(), U = read(), D = read();
        int[] ch = new int[F + 1];
        Deque<Integer> q = new ArrayDeque<>();
        ch[S] = 1;
        q.add(S);
        while (!q.isEmpty() && ch[G] == 0) {
            int num = q.poll();
            if (num + U <= F && ch[num + U] == 0) {
                ch[num + U] = ch[num] + 1;
                q.add(num + U);
            }
            if (num - D > 0 && ch[num - D] == 0) {
                ch[num - D] = ch[num] + 1;
                q.add(num - D);
            }
        }

        if (ch[G] == 0) System.out.println("use the stairs");
        else System.out.println(ch[G] - 1);
    }
}