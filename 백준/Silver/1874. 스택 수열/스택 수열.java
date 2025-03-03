class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] stack = new int[n];
        int num, push = 1, id = 0;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            num = read();
            while (push <= num) {
                stack[id++] = push++;
                sb.append("+\n");
            }
            if (stack[id - 1] == num) {
                sb.append("-\n");
                id--;
            } else {
                sb = new StringBuilder("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}