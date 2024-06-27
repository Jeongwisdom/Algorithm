import java.io.*;

class Main {
    static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) ch[i] = -1;
        for (int i = 0; i < n / 2; i++) {
            ch[i] = 0;
            DFS(ch, 1);
            ch[i] = -1;
        }
        answer *= 2;
        if (n % 2 == 1) {
            ch[n / 2] = 0;
            DFS(ch, 1);
        }
        System.out.println(answer);
    }

    static void DFS(int[] ch, int id) {
        if (id == n) answer++;
        else {
            loop:
            for (int i = 0; i < n; i++) {
                if (ch[i] == -1) {
                    for (int j = 1; j <= id; j++) {
                        if (i >= j && id - j == ch[i - j]) continue loop;
                        if (i + j < n && id - j == ch[i + j]) continue loop;
                    }
                    ch[i] = id;
                    DFS(ch, id + 1);
                    ch[i] = -1;
                }
            }
        }
    }
}