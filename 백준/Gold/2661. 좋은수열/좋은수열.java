class Main {
    static int n;
    static boolean flag = false;
    static StringBuilder answer = new StringBuilder();

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        DFS(new int[n], 0);
        System.out.println(answer);
    }

    static void DFS(int[] arr, int count) {
        if (flag) return;
        if (count == n) {
            for (int i = 0; i < n; i++) {
                answer.append(arr[i]);
            }
            flag = true;
        } else {
            loop:
            for (int i = 1; i < 4; i++) {
                arr[count] = i;
                for (int j = 0; j < (count + 1) / 2; j++) {
                    boolean ch = false;
                    for (int k = 0; k <= j; k++) {
                        if (arr[count - k] != arr[count - j - k - 1]) ch = true;
                    }
                    if (!ch) continue loop;
                }
                DFS(arr, count + 1);
            }
        }
    }
}