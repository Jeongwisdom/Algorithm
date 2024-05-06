import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> s;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            s = new Stack<>();
            if (str.length() % 2 == 1) s.push('(');
            else {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '(') {
                        s.push('(');
                    } else {
                        if (s.isEmpty()) {
                            s.push('(');
                            break;
                        }
                        s.pop();
                    }
                }
            }
            if (s.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}