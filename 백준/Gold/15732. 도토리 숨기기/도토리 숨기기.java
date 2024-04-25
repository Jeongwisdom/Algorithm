class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        int d = read();
        int[][] arr = new int[k][3];
        int min = n;
        int max = n;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = read();
            }
            if (arr[i][0] < min) min = arr[i][0];
        }

        while (min <= max) {
            int mid = (min + max) >> 1;
            long num = 0;
            for (int i = 0; i < k; i++) {
                if (arr[i][0] <= mid) {
                    int m = Math.min(arr[i][1], mid);
                    num += (m - arr[i][0]) / arr[i][2] + 1;
                }
            }
            if (d <= num) max = mid - 1;
            else min = mid + 1;
        }
        System.out.println(min);
    }
}