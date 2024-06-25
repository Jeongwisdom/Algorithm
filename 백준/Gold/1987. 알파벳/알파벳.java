import java.io.*;

class Main {
    static int r, c;
    static String[] arr;
    static boolean[] alphabet = new boolean[26];
    static int[][] ch;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        arr = new String[r];
        for (int i = 0; i < r; i++) arr[i] = br.readLine();
        ch = new int[r][c];
        alphabet[arr[0].charAt(0) - 65] = true;
        System.out.println(DFS(0, 0));
    }

    static int DFS(int x, int y) {
        int count = 0;
        int route = 1 << arr[x].charAt(y) - 65;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !alphabet[arr[nx].charAt(ny) - 65] && ch[nx][ny] != (ch[x][y] | route)) {
                alphabet[arr[nx].charAt(ny) - 65] = true;
                ch[nx][ny] = ch[x][y] | route;
                count = Math.max(count, DFS(nx, ny));
                alphabet[arr[nx].charAt(ny) - 65] = false;
            }
        }
        return count + 1;
    }
}