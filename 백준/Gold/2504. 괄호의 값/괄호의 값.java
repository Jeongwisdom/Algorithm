import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        boolean ch = true;
        int id = -1;
        for (char c: str.toCharArray()) {
            if (c == '(') arr[++id] = -1;
            else if (c == '[') arr[++id] = -2;
            else if (c == ')') {
                int n = 0;
                while (id >= 0 && arr[id] > 0) {
                    n += arr[id--];
                }
                if (id < 0 || arr[id] == -2) {
                    ch = false;
                    break;
                }
                if (n == 0) n = 1;
                arr[id] = 2 * n;
            } else {
                int n = 0;
                while (id >= 0 && arr[id] > 0) {
                    n += arr[id--];
                }
                if (id < 0 || arr[id] == -1) {
                    ch = false;
                    break;
                }
                if (n == 0) n = 1;
                arr[id] = 3 * n;
            }
        }
        int answer = 0;
        if (ch) {
            while (id >= 0) {
                if(arr[id] < 0) {
                    answer = 0;
                    break;
                }
                answer += arr[id--];
            }
        }
        System.out.println(answer);
    }
}