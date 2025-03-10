import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String str;
        int tail;
        while (n-- > 0) {
            str = br.readLine();
            tail = 0;
            for (char c: str.toCharArray()) {
                if (c == '(') {
                    tail++;
                } else {
                    if (tail == 0) {
                        tail++;
                        break;
                    } else {
                        tail--;
                    }
                }
            }
            if (tail == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}