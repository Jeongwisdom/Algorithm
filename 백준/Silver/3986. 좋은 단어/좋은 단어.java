class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);

        int[] stack;
        int tail, answer = 0;
        while (n-- > 0) {
            stack = new int[100000];
            tail = 0;
            while ((c = System.in.read()) > 64) {
                if (tail == 0 || stack[tail - 1] != c) {
                    stack[tail++] = c;
                } else {
                    tail--;
                }
            }
            if (tail == 0) answer++;
        }
        System.out.println(answer);
    }
}