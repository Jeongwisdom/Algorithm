import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] deque = new int[2 * n + 1];
        int head = n, tail = n;
        String str;
        while (n-- > 0) {
            str = br.readLine();
            switch (str.charAt(0)) {
                case 115:
                    sb.append(tail - head).append("\n");
                    break;
                case 101:
                    if (head == tail) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 102:
                    if (head == tail) sb.append("-1\n");
                    else sb.append(deque[head]).append("\n");
                    break;
                case 98:
                    if (head == tail) sb.append("-1\n");
                    else sb.append(deque[tail - 1]).append("\n");
                    break;
                default:
                    switch (str.charAt(1)) {
                        case 111:
                            switch (str.charAt(4)) {
                                case 98:
                                    if (head == tail) sb.append("-1\n");
                                    else sb.append(deque[--tail]).append("\n");
                                    break;
                                default:
                                    if (head == tail) sb.append("-1\n");
                                    else sb.append(deque[head++]).append("\n");
                            }
                            break;
                        default:
                            switch (str.charAt(5)) {
                                case 98:
                                    deque[tail++] = Integer.parseInt(str.substring(10));
                                    break;
                                default:
                                    deque[--head] = Integer.parseInt(str.substring(11));
                            }
                    }
            }
        }
        System.out.println(sb);
    }
}