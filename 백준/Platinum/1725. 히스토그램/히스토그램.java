import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        Stack<int[]> s = new Stack<>();
        s.push(new int[] {0, 0});
        int n = read();
        int answer = 0;
        for (int i = 1; i <= n + 1; i++) {
            int num;
            if (i == n + 1) num = 0;
            else num = read();
            while (s.size() > 1 && s.peek()[1] >= num) {
                int[] a = s.pop();
                answer = Math.max(answer, (i - (s.peek()[0] + 1)) * a[1]);
            }
            s.push(new int[] {i, num});
        }
        System.out.println(answer);
    }
}