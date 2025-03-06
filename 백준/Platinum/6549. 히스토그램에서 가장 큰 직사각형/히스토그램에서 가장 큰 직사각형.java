class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N;
        while ((N = read()) > 0) {
            int[] arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                arr[i] = read();
            }

            int[] stack = new int[N + 1];
            int[] numId = new int[N + 1];
            int id, stackId = -1;
            long answer = 0;
            for (int i = 0; i <= N; i++) {
                id = i;
                while (stackId >= 0 && stack[stackId] >= arr[i]) {
                    answer = Math.max(answer, (long) stack[stackId] * (i - numId[stackId]));
                    id = numId[stackId];
                    stackId--;
                }
                stack[++stackId] = arr[i];
                numId[stackId] = id;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}