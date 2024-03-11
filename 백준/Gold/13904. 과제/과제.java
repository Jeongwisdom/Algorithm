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
        
        Arrays.sort(arr, (q1, q2) -> {
            if(q2[1] == q1[1]) return q1[0] - q2[0];
            return q2[1] - q1[1];
        });
        int answer = 0;
        boolean[] limit = new boolean[1001];
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j > 0; j--) {
                if (!limit[j]) {
                    limit[j] = true;
                    answer += arr[i][1];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}