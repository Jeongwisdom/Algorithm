import java.io.*;
import java.util.*;

class Main {
    static StringBuilder answer = new StringBuilder();
    static int[] temp = new int[6];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; ; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            BF(arr, 0, 0);
            answer.append("\n");
        }
        System.out.print(answer);
    }
    
    public static void BF(int[] arr, int count, int id) {
        if (count == 6) {
            for (int num: temp) {
                answer.append(num).append(" ");
            }
            answer.append("\n");
        } else {
            for (int i = id; i <= arr.length - 6 + count; i++) {
                temp[count] = arr[i];
                BF(arr, count + 1, i + 1);
            }
        }
    }
}