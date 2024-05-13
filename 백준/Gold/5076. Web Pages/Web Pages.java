import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder str;
        Stack<String> s;
        while (!(str = new StringBuilder(br.readLine())).toString().equals("#")) {
            s = new Stack<>();
            if (str.toString().contains("<")) {
                StringTokenizer st = new StringTokenizer(str.toString(), "<");
                while (st.hasMoreTokens()) {
                    String[] sp = st.nextToken().split(">");
                    if (sp[0].charAt(0) == '/') {
                        if (s.isEmpty() || !s.peek().equals(sp[0].substring(1))) {
                            s.push("1");
                            break;
                        } else s.pop();
                    } else if (sp[0].charAt(sp[0].length() - 1) != '/') {
                        s.push(sp[0].split(" ")[0]);
                    }
                }
            }
            if (s.isEmpty()) sb.append("legal");
            else sb.append("illegal");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}