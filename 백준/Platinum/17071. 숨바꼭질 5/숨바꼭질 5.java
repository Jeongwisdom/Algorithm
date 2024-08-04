import java.io.*;
import java.util.*;

class Main {
    static boolean[] odd = new boolean[500001];
    static boolean[] even = new boolean[500001];
    static int[] q = new int[1000001];
    static int head = 0, tail = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int answer = 0;
        q[tail++] = n;
        even[n] = true;
        while (head < tail) {
            int len = tail;
            k += answer;
            if (k > 500000) {
                answer = -1;
                break;
            }
            if ((answer % 2 == 0 && even[k]) || (answer % 2 == 1 && odd[k])) break;
            for (int i = head; i < len; i++) {
                int num = q[head++];
                boolean ch = (answer + 1) % 2 == 0;
                if (2 * num <= 500000) add(2 * num, ch);
                if (num + 1 <= 500000) add(num + 1, ch);
                if (num - 1 >= 0) add(num - 1, ch);
            }
            answer++;
        }
        if (head == tail) answer = -1;
        System.out.println(answer);
    }

    static void add(int num, boolean isEven) {
        if (isEven && !even[num]) {
            even[num] = true;
            q[tail++] = num;
        } else if (!isEven && !odd[num]) {
            odd[num] = true;
            q[tail++] = num;
        }
    }
}