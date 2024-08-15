import java.io.*;

class Main {
    static String[] arr = new String[5];
    static boolean[] ch = new boolean[1 << 25];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) arr[i] = br.readLine();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i].charAt(j) == 'S') {
                    int bit = 1 << i * 5 + j;
                    ch[bit] = true;
                    DFS(bit, 1, 1);
                }
            }
        }
        System.out.println(answer);
    }

    static void DFS(int bit, int cnt, int numOfS) {
        if (7 - cnt + numOfS < 4) return;
        if (cnt == 7) {
            answer++;
            return;
        }
        for (int i = 0; i < 25; i++) {
            if ((bit & 1 << i) == 0) continue;
            int x = i / 5;
            int y = i % 5;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || ny < 0 || nx > 4 || ny > 4) continue;
                int nPoint = nx * 5 + ny;
                int nPointBit = 1 << nPoint;
                int nBit = bit | nPointBit;
                if (ch[nBit]) continue;
                ch[nBit] = true;
                if (arr[nx].charAt(ny) == 'S') DFS(nBit, cnt + 1, numOfS + 1);
                else DFS(nBit, cnt + 1, numOfS);
            }
        }
    }
}