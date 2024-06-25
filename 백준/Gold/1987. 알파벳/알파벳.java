import java.io.*;

class Main {
    static int r, c, answer = 0;
    static String[] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        arr = new String[r];
        for (int i = 0; i < r; i++) arr[i] = br.readLine();
        boolean[] alphabet = new boolean[26];
        boolean[][] ch = new boolean[r][c];
        alphabet[arr[0].charAt(0) - 65] = true;
        ch[0][0] = true;
        DFS(ch, alphabet, 0, 0, 1);
        System.out.println(answer);
    }

    static void DFS(boolean[][] ch, boolean[] alphabet, int x, int y, int count) {
        if (answer < count) answer = count;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !ch[nx][ny] && !alphabet[arr[nx].charAt(ny) - 65]) {
                alphabet[arr[nx].charAt(ny) - 65] = true;
                ch[nx][ny] = true;
                DFS(ch, alphabet, nx, ny, count + 1);
                ch[nx][ny] = false;
                alphabet[arr[nx].charAt(ny) - 65] = false;
            }
        }
    }
}