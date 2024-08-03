class Main {
    static int n, m, h, answer = -1;
    static int[][] arr;

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        h = read();
        arr = new int[h][n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            a = read() - 1;
            b = read() - 1;
            arr[a][b] = 1;
            arr[a][b + 1] = -1;
        }

        for (int i = 0; i < 4; i++) {
            climb(0, 0, 0, 0, i);
            if (answer == i) break;
        }
        System.out.println(answer);
    }

    static void climb(int start, int row, int ladder, int count, int goal) {
        if (goal == answer) return;
        if (start == n - 1) {
            answer = count;
            return;
        }
        if (row == h) {
            if (start == ladder) climb(start + 1, 0, start + 1, count, goal);
            return;
        }
        if (ladder < n - 1 && arr[row][ladder] == 0 && arr[row][ladder + 1] == 0 && count < goal) {
            arr[row][ladder] = 1;
            arr[row][ladder + 1] = -1;
            climb(start, row + 1, ladder + 1, count + 1, goal);
            arr[row][ladder] = 0;
            arr[row][ladder + 1] = 0;
        }
        if (ladder > 0 && arr[row][ladder - 1] == 0 && arr[row][ladder] == 0 && count < goal) {
            arr[row][ladder - 1] = 1;
            arr[row][ladder] = -1;
            climb(start, row + 1, ladder - 1, count + 1, goal);
            arr[row][ladder - 1] = 0;
            arr[row][ladder] = 0;
        }
        climb(start, row + 1, ladder + arr[row][ladder], count, goal);
    }
}