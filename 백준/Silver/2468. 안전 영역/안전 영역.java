class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][n];
        int l = 100;
        int r = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = read();
                if (arr[i][j] < l) l = arr[i][j];
                else if (arr[i][j] > r) r = arr[i][j];
            }
        }
        
        int answer = 1;
        for (int i = l; i < r; i++) {
            int count = count(arr, n, i);
            if (answer <= count) answer = count;
        }
        System.out.println(answer);
    }
    
    static int count(int[][] arr, int n, int k) {
        int count = 0;
        boolean[][] ch = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!ch[i][j] && arr[i][j] > k) {
                    count++;
                    DFS(arr, ch, i, j, n, k);
                }
            }
        }
        return count;
    }
    
    static void DFS(int[][] arr, boolean[][] ch, int x, int y, int n, int mid) {
        ch[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !ch[nx][ny] && arr[nx][ny] > mid) {
                DFS(arr, ch, nx, ny, n, mid);
            }
        }
    }
}