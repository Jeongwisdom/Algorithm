class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = read();
            int[] arr = new int[1001];
            for (int j = 0; j < k; j++) {
                int num = read();
                arr[num]++;
            }

            int max = 0;
            int o = 1;
            for (int m = 1; m < 1001; m++) {
                if (max < arr[m]) {
                    max = arr[m];
                    o = m;
                }
            }
            sb.append(o).append("\n");
        }
        System.out.println(sb);
    }
}