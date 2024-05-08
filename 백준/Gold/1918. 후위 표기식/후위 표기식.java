import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> s = new Stack<>();
        String str = br.readLine();
        int p = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 48) {
                if (c == ')') {
                    char tmp;
                    while ((tmp = (char) s.pop()[0]) != '(') sb.append(tmp);
                    p--;
                } else {
                    int pr = findPriority(c) - p * 3;
                    if (c != '(') {
                        while (!s.isEmpty() && pr >= s.peek()[1]) {
                            sb.append((char) s.pop()[0]);
                        }
                    } else p++;
                    s.push(new int[] {c, pr});
                }
            } else sb.append(c);
        }
        while (!s.isEmpty()) sb.append((char) s.pop()[0]);
        System.out.println(sb);
    }

    static int findPriority(char c) {
        char[] arr = {'(', ')', '*', '/', '+', '-'};
        int i = 0;
        for (; i < 6; i++) {
            if (c == arr[i]) break;
        }
        return 300 + i / 2;
    }
}