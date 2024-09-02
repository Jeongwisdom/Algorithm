import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (char c: br.readLine().toCharArray()) {
            if ('a' <= c && c <= 'z') sb.append((char) (c - 32));
            else sb.append((char) (c + 32));
        }
        System.out.println(sb);
    }
}