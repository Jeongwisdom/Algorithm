import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        int time = 0;
        Arrays.sort(arr, (i1, i2) -> {
            if (i1[1] == i2[1]) return i1[0] - i2[0];
            return i1[1] - i2[1];
        });
        for (int i = 0; i < n; i++) {
            if (time <= arr[i][0]) {
                answer++;
                time = arr[i][1];
            }
        }
        System.out.println(answer);
    }
}