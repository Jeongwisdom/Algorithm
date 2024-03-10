import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];
        int answer = 0;
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            answer += 20 * Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        answer += arr[0];
        for (int i = 1; i < 11; i++) {
            arr[i] += arr[i - 1];
            answer += arr[i];
        }
        
        System.out.println(answer);
    }
}