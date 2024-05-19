class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
            }
        }
        
        boolean[][] ch = new boolean[n][m];
        int count = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !ch[i][j]) {
                    count++;
                    area = Math.max(area, checkArea(arr, ch, i, j));
                }
            }
        }
        System.out.println(count + "\n" + area);
    }
    
    static int checkArea(int[][] arr, boolean[][] ch, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int area = 1;
        ch[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && arr[nx][ny] == 1 && !ch[nx][ny]) {
                ch[nx][ny] = true;
                area += checkArea(arr, ch, nx, ny);
            }
        }
        return area;
    }
}