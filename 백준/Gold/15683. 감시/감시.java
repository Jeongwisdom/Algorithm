class Main {
    static int N, M, answer = Integer.MAX_VALUE, tail = 0;
    static int[][] arr, point;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        arr = new int[N][M];
        point = new int[8][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = read();
                if (arr[i][j] > 0 && arr[i][j] < 6) {
                    point[tail][0] = i;
                    point[tail++][1] = j;
                }
            }
        }

        simulation(0);
        System.out.println(answer);
    }

    static void simulation(int id) {
        if (id == tail) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) cnt++;
                }
            }
            if (cnt < answer) answer = cnt;
            return;
        }
        switch (arr[point[id][0]][point[id][1]]) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    see(point[id][0], point[id][1], i, -1);
                    simulation(id + 1);
                    see(point[id][0], point[id][1], i, 1);
                }
                break;
            case 2:
                see(point[id][0], point[id][1], 0, -1);
                see(point[id][0], point[id][1], 2, -1);
                simulation(id + 1);
                see(point[id][0], point[id][1], 0, 1);
                see(point[id][0], point[id][1], 2, 1);

                see(point[id][0], point[id][1], 1, -1);
                see(point[id][0], point[id][1], 3, -1);
                simulation(id + 1);
                see(point[id][0], point[id][1], 1, 1);
                see(point[id][0], point[id][1], 3, 1);
                break;
            case 3:
                see(point[id][0], point[id][1], 0, -1);
                for (int i = 0; i < 4; i++) {
                    see(point[id][0], point[id][1], (i + 1) % 4, -1);
                    simulation(id + 1);
                    see(point[id][0], point[id][1], i, 1);
                }
                see(point[id][0], point[id][1], 0, 1);
                break;
            case 4:
                see(point[id][0], point[id][1], 0, -1);
                see(point[id][0], point[id][1], 1, -1);
                for (int i = 0; i < 4; i++) {
                    see(point[id][0], point[id][1], (i + 2) % 4, -1);
                    simulation(id + 1);
                    see(point[id][0], point[id][1], i, 1);
                }
                see(point[id][0], point[id][1], 0, 1);
                see(point[id][0], point[id][1], 1, 1);
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    see(point[id][0], point[id][1], i, -1);
                }
                simulation(id + 1);
                for (int i = 0; i < 4; i++) {
                    see(point[id][0], point[id][1], i, 1);
                }
                break;
        }
    }

    static void see(int x, int y, int id, int num) {
        while (x >= 0 && y >= 0 && x < N && y < M) {
            if (arr[x][y] <= 0) arr[x][y] += num;
            if (arr[x][y] == 6) break;
            x += dx[id];
            y += dy[id];
        }
    }
}