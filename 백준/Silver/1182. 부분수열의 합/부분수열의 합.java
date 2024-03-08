import java.io.*;
import java.util.*;

class Main {
    static int s, answer;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        BF(0, 0);
        if (s == 0) answer--;
        System.out.println(answer);
    }
    
    public static void BF(int count, int sum) {
        if (count == arr.length) {
            if (sum == s) answer++;
        }
        else {
            BF(count + 1, sum + arr[count]);
            BF(count + 1, sum);
        }
    }
}