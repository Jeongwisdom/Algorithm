class Solution {
    int n, m;
    int[] areas = new int[250000];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        int id = 2;
        int answer = 0;
        int[] a = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1) {
                    land[i][j] = id;
                    int[] idx = {j, j};
                    DFS(land, i, j, id, idx);
                    for (int k = idx[0]; k <= idx[1]; k++) {
                        a[k] += areas[id];
                    }
                    id++;
                }
            }
            if (answer < a[j]) answer = a[j];
        }
        return answer;
    }
    
    void DFS(int[][] land, int x, int y, int k, int[] idx) {
        areas[k]++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && land[nx][ny] == 1) {
                land[nx][ny] = k;
                if (ny < idx[0]) idx[0] = ny;
                else if (idx[1] < ny) idx[1] = ny;
                DFS(land, nx, ny, k, idx);
            }
        }
    }
}