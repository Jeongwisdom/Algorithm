import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[291];
        int answer = 0;
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
            answer += 20 * Integer.parseInt(st.nextToken());
        }
        
        int last = 0;
        for (int i = 1; i < 291; i++) {
            if (arr[i] != 0) {
                answer += last * arr[i] + i * arr[i] * (arr[i] + 1) / 2;
                last = last + i * arr[i];
            }
        }
        
        System.out.println(answer);
    }
}