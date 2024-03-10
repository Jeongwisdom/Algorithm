import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int answer = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > num) {
                answer++;
                num = arr[i] + l - 1;
            }
        }
        System.out.println(answer);
    }
}