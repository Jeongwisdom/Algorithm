class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int N = read(), S = read();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; l < N; l++) {
            while (r < N && sum < S) {
                sum += arr[r++];
            }
            if (sum < S) break;
            answer = Math.min(answer, r - l);
            sum -= arr[l];
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}