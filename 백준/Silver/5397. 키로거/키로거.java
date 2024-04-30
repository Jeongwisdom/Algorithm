import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Deque<Character> l = new ArrayDeque<>();
            Deque<Character> r = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '<') {
                    if (!l.isEmpty()) r.offerFirst(l.pollLast());
                } else if (c == '>') {
                    if (!r.isEmpty()) l.offer(r.poll());
                } else if (c == '-') {
                    if (!l.isEmpty()) l.pollLast();
                } else l.offer(c);
            }
            for (char c: l) sb.append(c);
            for (char c: r) sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}