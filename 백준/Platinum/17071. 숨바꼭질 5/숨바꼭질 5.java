import java.io.*;
import java.util.*;

class Main {
    static boolean[] odd = new boolean[500001];
    static boolean[] even = new boolean[500001];
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int answer = 0;
        q.offer(n);
        even[n] = true;
        while (!q.isEmpty()) {
            int len = q.size();
            k += answer;
            if (k > 500000) {
                answer = -1;
                break;
            }
            if ((answer % 2 == 0 && even[k]) || (answer % 2 == 1 && odd[k])) break;
            for (int i = 0; i < len; i++) {
                int num = q.poll();
                boolean ch = (answer + 1) % 2 == 0;
                if (2 * num <= 500000) add(2 * num, ch);
                if (num + 1 <= 500000) add(num + 1, ch);
                if (num - 1 >= 0) add(num - 1, ch);
            }
            answer++;
        }
        if (q.isEmpty()) answer = -1;
        System.out.println(answer);
    }

    static void add(int num, boolean isEven) {
        if (isEven && !even[num]) {
            even[num] = true;
            q.offer(num);
        } else if (!isEven && !odd[num]) {
            odd[num] = true;
            q.offer(num);
        }
    }
}