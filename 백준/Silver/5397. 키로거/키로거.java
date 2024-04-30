import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> l, r;
        String str;
        char c;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            l = new ArrayDeque<>();
            r = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                c = str.charAt(j);
                if (c == '<') {
                    if (!l.isEmpty()) r.offerFirst(l.pollLast());
                } else if (c == '>') {
                    if (!r.isEmpty()) l.offer(r.poll());
                } else if (c == '-') {
                    if (!l.isEmpty()) l.pollLast();
                } else {
                    l.offer(c);
                }
            }
            for (char ch: l) {
                sb.append(ch);
            }
            for (char ch: r) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}