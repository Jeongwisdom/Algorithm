import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[1001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }
        
        int answer = 0;
        for (int i = 0; i < 1001; i++) {
            if (arr[i] == 1) {
                answer++;
                i += l - 1;
            }
        }
        System.out.println(answer);
    }
}