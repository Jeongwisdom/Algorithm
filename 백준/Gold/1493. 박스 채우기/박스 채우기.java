import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        long area = (long) l * w * h;
        long cal = 0;
        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            cal *= 8;
            long line = (long) Math.pow(2, arr[i][0]);
            long count = (l / line) * (w / line) * (h / line) - cal;
            if (count > arr[i][1]) count = arr[i][1];
            answer += count;
            cal += count;
            if (cal == area) break;
        }

        if (area > cal) answer = -1;
        System.out.println(answer);
    }
}