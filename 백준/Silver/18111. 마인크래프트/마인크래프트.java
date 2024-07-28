class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int b = read();
        int[] land = new int[257];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = read();
                land[num]++;
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        loop:
        for (int i = 0; i < 257; i++) {
            int spare = 0;
            int inv = b;
            for (int j = 256; j >= 0; j--) {
                if (land[j] == 0 || j == i) continue;
                int dif = Math.abs(i - j);
                if (j > i) {
                    spare += 2 * dif * land[j];
                    inv += dif * land[j];
                } else {
                    if (dif * land[j] > inv) continue loop;
                    spare += dif * land[j];
                    inv -= dif * land[j];
                }
            }
            if (spare <= time) {
                time = spare;
                height = i;
            }
        }
        System.out.println(time + " " + height);
    }
}