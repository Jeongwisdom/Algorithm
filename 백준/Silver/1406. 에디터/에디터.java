import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int cursor = sb.length();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if (c == 'L') cursor -= cursor == 0? 0: 1;
            else if (c == 'D') cursor += cursor == sb.length()? 0: 1;
            else if (c == 'B') {
                if(cursor > 0) sb.deleteCharAt(--cursor);
            } else sb.insert(cursor++, st.nextToken());
        }
        System.out.println(sb);
    }
}