import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int head, tail, m, n = Integer.parseInt(br.readLine());
        String command, s;
        String[] split;
        int[] arr;
        boolean r;
        loop:
        while (n-- > 0) {
            command = br.readLine();
            m = Integer.parseInt(br.readLine());
            s = br.readLine();
            split = s.substring(1, s.length() - 1).split(",");
            arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            head = 0;
            tail = m - 1;
            r = false;
            for (char c: command.toCharArray()) {
                if (c == 'R') r = !r;
                else {
                    if (head > tail) {
                        sb.append("error\n");
                        continue loop;
                    }
                    if (r) tail--;
                    else head++;
                }
            }

            sb.append("[");
            if (r) {
                for (int i = tail; i >= head; i--) {
                    sb.append(arr[i]);
                    if (i > head) sb.append(",");
                }
            } else {
                for (int i = head; i <= tail; i++) {
                    sb.append(arr[i]);
                    if (i < tail) sb.append(",");
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}