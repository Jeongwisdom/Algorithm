import java.io.*;
import java.util.*;

class Main {
    static StringBuilder answer;
    static int[] temp, arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        temp = new int[6];
        for (int j = 0; ; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            BF(0, 0);
            answer.append("\n");
        }
        System.out.print(answer);
    }
    
    public static void BF(int count, int id) {
        if (count == 6) {
            for (int num: temp) {
                answer.append(num).append(" ");
            }
            answer.append("\n");
        } else {
            for (int i = id; i <= arr.length - 6 + count; i++) {
                temp[count] = arr[i];
                BF(count + 1, i + 1);
            }
        }
    }
}