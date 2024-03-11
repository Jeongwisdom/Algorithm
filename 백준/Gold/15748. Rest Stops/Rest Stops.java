import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] rest = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rest[i][0] = Integer.parseInt(st.nextToken());
            rest[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(rest, (r1, r2) -> r2[1] - r1[1]);
        long diff = f - b;
        int last = 0;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (last < rest[i][0]) {
                answer += (rest[i][0] - last) * diff * rest[i][1];
                last = rest[i][0];
            }
        }
        System.out.println(answer);
    }
}