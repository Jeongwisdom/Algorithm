import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), s = read();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] {read(), read()});
        }
        list.sort((l1, l2) -> l1[0] - l2[0]);

        int answer = -1, ex = 0;
        for (int[] a: list) {
            if (ex + m <= a[0]) {
                answer = ex;
                break;
            }
            ex = a[0] + a[1];
        }
        if (answer == -1 && ex + m <= s) answer = ex;
        System.out.println(answer);
    }
}