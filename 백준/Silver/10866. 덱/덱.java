class Main {
    static int readInt() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    static int readStr() throws Exception {
        int c, n = System.in.read();
        while ((c = System.in.read()) > 94) n += c;
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = readInt();
        int[] deque = new int[2 * n + 1];
        int head = n, tail = n;
        while (n-- > 0) {
            switch (readStr()) {
                case 443:
                    sb.append(tail - head).append("\n");
                    break;
                case 559:
                    if (head == tail) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 553:
                    if (head == tail) sb.append("-1\n");
                    else sb.append(deque[head]).append("\n");
                    break;
                case 401:
                    if (head == tail) sb.append("-1\n");
                    else sb.append(deque[tail - 1]).append("\n");
                    break;
                case 983:
                    if (head == tail) sb.append("-1\n");
                    else sb.append(deque[head++]).append("\n");
                    break;
                case 831:
                    if (head == tail) sb.append("-1\n");
                    else sb.append(deque[--tail]).append("\n");
                    break;
                case 1096:
                    deque[--head] = readInt();
                    break;
                default:
                    deque[tail++] = readInt();
            }
        }
        System.out.println(sb);
    }
}