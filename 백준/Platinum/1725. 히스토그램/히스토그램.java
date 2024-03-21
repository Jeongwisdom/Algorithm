import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int answer = 0;
        for (int i = 1; i < n + 2; i++) {
            while (!s.isEmpty()) {
                if (arr[s.peek()] <= arr[i]) break;
                int index = s.pop();
                answer = Math.max(answer, arr[index] * (i - (s.peek() + 1)));
            }
            s.push(i);
        }
        System.out.println(answer);
    }
}