import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        int[] stack;
        int tail;
        while (true) {
            str = br.readLine();
            if (str.charAt(0) == '.') break;
            stack = new int[str.length() + 1];
            tail = 0;
            for (char c: str.toCharArray()) {
                if (c == '(') {
                    stack[tail++] = 1;
                } else if (c == ')') {
                    if (tail == 0 || stack[tail - 1] != 1) {
                        stack[tail++] = 3;
                        break;
                    }
                    tail--;
                } else if (c == '[') {
                    stack[tail++] = 2;
                } else if (c == ']') {
                    if (tail == 0 || stack[tail - 1] != 2) {
                        stack[tail++] = 3;
                        break;
                    }
                    tail--;
                }
            }
            if (tail == 0) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}