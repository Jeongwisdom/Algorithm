import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] arr = new int[split[0].length()];
        for (int i = 0; i < split[0].length(); i++) {
            arr[i] = split[0].charAt(i) - '0';
        }
        int k = Integer.parseInt(split[1]);

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(arr);
        int count = 0;
        while (!q.isEmpty()) {
            if (count == k) break;
            int len = q.size();
            boolean[] ch = new boolean[10000000];
            for (int i = 0; i < len; i++) {
                int[] a = q.poll();
                for (int j = 0; j < a.length; j++) {
                    for (int l = j + 1; l < a.length; l++) {
                        if (j != 0 || a[l] != 0) {
                            int[] b = a.clone();
                            int tmp = b[j];
                            b[j] = b[l];
                            b[l] = tmp;
                            int num = parseInt(b);
                            if (!ch[num]) {
                                ch[num] = true;
                                q.offer(b);
                            }
                        }
                    }
                }
            }
            count++;
        }

        int answer = -1;
        while (count == k && !q.isEmpty()) {
            int num = parseInt(q.poll());
            if (num > answer) answer = num;
        }
        System.out.println(answer);
    }

    static int parseInt(int[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            c = c * 10 + arr[i];
        }
        return c;
    }
}