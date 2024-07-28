import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] land = new int[257];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
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