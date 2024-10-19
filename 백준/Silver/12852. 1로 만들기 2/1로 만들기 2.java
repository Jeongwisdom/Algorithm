import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        if (n == 1) System.out.println("0\n1");
        else {
            int[] arr = new int[n + 1];
            arr[n] = -1;
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(n);
            int len, num, three, two, one, id = 1;
            loop:
            while (true) {
                len = q.size();
                for (int i = 0; i < len; i++) {
                    num = q.poll();
                    if (num % 3 == 0) {
                        three = num / 3;
                        if (arr[three] == 0) {
                            arr[three] = num;
                            q.offer(three);
                        }
                        if (three == 1) break loop;
                    }
                    if (num % 2 == 0) {
                        two = num / 2;
                        if (arr[two] == 0) {
                            arr[two] = num;
                            q.offer(two);
                        }
                        if (two == 1) break loop;
                    }
                    one = num - 1;
                    if (arr[one] == 0) {
                        arr[one] = num;
                        q.offer(one);
                    }
                    if (one == 1) break loop;
                }
                id++;
            }

            StringBuilder sb = new StringBuilder();
            sb.insert(0, 1);
            num = arr[1];
            while (num != -1) {
                sb.insert(0, " ").insert(0, num);
                num = arr[num];
            }
            sb.insert(0, "\n").insert(0, id);
            System.out.println(sb);
        }
    }
}