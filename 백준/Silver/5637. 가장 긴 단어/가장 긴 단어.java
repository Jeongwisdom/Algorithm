import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        StringBuilder sb;
        loop:
        while (true) {
            String str = br.readLine().toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                sb = new StringBuilder();
                char c = str.charAt(i);
                while (c == '-' || ('a' <= c && c <= 'z')) {
                    sb.append(c);
                    i++;
                    if (i == str.length()) break;
                    c = str.charAt(i);
                }
                if (sb.toString().contains("e-n-d")) break loop;
                if (answer.length() < sb.length()) answer = sb.toString();
            }
        }
        System.out.println(answer);
    }
}