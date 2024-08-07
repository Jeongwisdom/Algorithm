import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;
        int id = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean ch = true;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (command.equals("TURN")) {
                if (num == 0) {
                    id = (id + 1) % 4;
                } else {
                    id--;
                    if (id < 0) id = 3;
                }
            } else {
                x += dx[id] * num;
                y += dy[id] * num;
                if (x < 0 || y < 0 || x > n || y > n) {
                    ch = false;
                    break;
                }
            }
        }
        if (!ch) System.out.println(-1);
        else System.out.println(y + " " + x);
    }
}