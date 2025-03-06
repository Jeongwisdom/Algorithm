class Main {
    static int c, n, N, id, stackId;
    static int[] stack, numId, arr;
    static long answer;

    static int read() throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while ((N = read()) > 0) {
            arr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                arr[i] = read();
            }

            stack = new int[N + 1];
            numId = new int[N + 1];
            stackId = -1;
            answer = 0;
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