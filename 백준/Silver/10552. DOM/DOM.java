import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] arr = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int favorite = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());
            if (arr[hate] == 0) arr[hate] = favorite;
        }
        int answer = 0;
        boolean[] ch = new boolean[m + 1];
        while (arr[p] > 0) {
            if (ch[p]) {
                answer = -1;
                break;
            }
            ch[p] = true;
            p = arr[p];
            answer++;
        }
        System.out.println(answer);
    }
}