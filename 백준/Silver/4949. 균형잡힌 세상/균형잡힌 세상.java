class Main {
    static void read() throws Exception {
        int c;
        while ((c = System.in.read()) > 31) {}
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int[] stack;
        int tail, c;
        while ((c = System.in.read()) != '.') {
            stack = new int[101];
            tail = 0;
            while (c > 31) {
                if (c == '(') {
                    stack[tail++] = 1;
                } else if (c == ')') {
                    if (tail == 0 || stack[tail - 1] != 1) {
                        stack[tail++] = 3;
                        read();
                        break;
                    }
                    tail--;
                } else if (c == '[') {
                    stack[tail++] = 2;
                } else if (c == ']') {
                    if (tail == 0 || stack[tail - 1] != 2) {
                        stack[tail++] = 3;
                        read();
                        break;
                    }
                    tail--;
                }
                c = System.in.read();
            }
            if (tail == 0) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}