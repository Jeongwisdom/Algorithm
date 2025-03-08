class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        long answer = 0;
        int[] stack = new int[n];
        int[] num = new int[n];
        int cnt, tail = 0;
        for (int i = 0; i < n; i++) {
            cnt = 1;
            while (tail > 0 && stack[tail - 1] <= arr[i]) {
                answer += num[tail - 1];
                if (stack[tail - 1] == arr[i]) cnt += num[tail - 1];
                tail--;
            }
            if (tail > 0) answer++;
            stack[tail] = arr[i];
            num[tail++] = cnt;
        }
        System.out.println(answer);
    }
}