import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> l = new ArrayDeque<>();
        Deque<Character> r = new ArrayDeque<>();
        String init = br.readLine();
        for (int i = 0; i < init.length(); i++) {
            l.offer(init.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            if (c == 'L') {
                if (!l.isEmpty()) r.offerFirst(l.pollLast());
            } else if (c == 'D') {
                if (!r.isEmpty()) l.offer(r.poll());
            } else if (c == 'B') {
                if(!l.isEmpty()) l.pollLast();
            } else l.offer(str.charAt(2));
        }
        StringBuilder sb = new StringBuilder();
        for (char c: l) sb.append(c);
        for (char c: r) sb.append(c);
        System.out.println(sb);
    }
}