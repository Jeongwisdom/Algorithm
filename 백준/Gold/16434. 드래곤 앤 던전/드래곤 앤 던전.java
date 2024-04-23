class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int atk = read();
        int[][] room = new int[n][3];
        long min = 1;
        long max = 1;
        long cAtk = atk;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                room[i][j] = read();
            }
            if (room[i][0] == 1) max += (room[i][1] * (room[i][2] / cAtk));
            else cAtk += room[i][1];
        }

        while (min <= max) {
            long mid = (min + max) >> 1;
            long hp = mid;
            cAtk = atk;
            for (int i = 0; i < n; i++) {
                if (room[i][0] == 1) {
                    long num = room[i][2] / cAtk;
                    if (room[i][2] % cAtk == 0) num--;
                    hp -= (room[i][1] * num);
                } else {
                    cAtk += room[i][1];
                    hp += room[i][2];
                    if (hp > mid) hp = mid;
                }
                if (hp <= 0) break;
            }
            if (hp <= 0) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(min);
    }
}