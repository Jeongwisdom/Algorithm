class Main {
    static int c, n;

    static int read() throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = read();

        int[] stack = new int[N];
        int[] answer = new int[N];
        int id = -1;
        for (int i = N - 1; i >= 0; i--) {
            while (id >= 0) {
                if (numbers[i] < stack[id]) break;
                id--;
            }
            answer[i] = id >= 0? stack[id]: -1;
            stack[++id] = numbers[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}