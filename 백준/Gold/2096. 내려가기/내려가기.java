class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n + 1][5];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 4; j++) {
                arr[i][j] = read();
            }
        }

        int[][] max = new int[n + 1][5];
        int[][] min = new int[n + 1][5];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 4; j++) {
                min[i + 1][j] = Integer.MAX_VALUE;
            }
            for (int j = 1; j < 4; j++) {
                max[i + 1][j - 1] = Math.max(max[i + 1][j - 1], max[i][j] + arr[i + 1][j - 1]);
                max[i + 1][j] = Math.max(max[i + 1][j], max[i][j] + arr[i + 1][j]);
                max[i + 1][j + 1] = Math.max(max[i + 1][j + 1], max[i][j] + arr[i + 1][j + 1]);

                min[i + 1][j - 1] = Math.min(min[i + 1][j - 1], min[i][j] + arr[i + 1][j - 1]);
                min[i + 1][j] = Math.min(min[i + 1][j], min[i][j] + arr[i + 1][j]);
                min[i + 1][j + 1] = Math.min(min[i + 1][j + 1], min[i][j] + arr[i + 1][j + 1]);
            }
        }

        int ma = 0;
        int mi = Integer.MAX_VALUE;
        for (int i = 1; i < 4; i++) {
            ma = Math.max(ma, max[n][i]);
            mi = Math.min(mi, min[n][i]);
        }
        System.out.println(ma + " " + mi);
    }
}