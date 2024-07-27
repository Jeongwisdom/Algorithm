import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] argd) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] flowers = new int[n];      
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] ch;
        for (int i = 0; i < n; i++) {
            ch = new boolean[1001];
            int sum = 0;
            for (int j = 0; j < n - i; j++) {
                sum += flowers[i + j];
                ch[flowers[i + j]] = true;
                if ((sum % (double) (j + 1)) == 0) {
                    if (ch[sum / (j + 1)]) answer++;
                }
            } 
        }
        System.out.println(answer);
    }
}