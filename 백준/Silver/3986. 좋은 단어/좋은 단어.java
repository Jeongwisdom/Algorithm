import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() % 2 == 1) continue;
            char[] s = new char[str.length()];
            int id = -1;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (id == -1 || s[id] != c) {
                    s[++id] = c;
                } else id--;
            }
            if (id == -1) answer++;
        }
        System.out.println(answer);
    }
}