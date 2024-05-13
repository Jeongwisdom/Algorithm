import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        Stack<String> s;
        while (!(str = br.readLine()).equals("#")) {
            s = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '<') {
                    char c;
                    int j = i + 1;
                    while ((c = str.charAt(j)) != ' ' && c != '>') j++;
                    if (str.charAt(i + 1) == '/') {
                        if (s.isEmpty() || !s.peek().equals(str.substring(i + 2, j))) {
                            s.push("1");
                            break;
                        } else s.pop();
                    } else {
                        if (str.charAt(j + 1) != '/') s.push(str.substring(i + 1, j));
                    }
                    i = j;
                }
            }
            if (s.isEmpty()) sb.append("legal");
            else sb.append("illegal");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}