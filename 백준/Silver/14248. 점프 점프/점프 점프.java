import java.io.*;

class Main {
    static int n, answer = 0;
    static int[] arr;
    static boolean[] ch;
    static int[] d = {1,  -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        ch = new boolean[n + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(split[i - 1]);
        }
        int s = Integer.parseInt(br.readLine());
        ch[s] = true;
        DFS(s);
        System.out.println(answer);
    }
    
    static void DFS(int id) {
        answer++;
        for (int i = 0; i < 2; i++) {
            int next = id + d[i] * arr[id];
            if (next > 0 && next <= n && !ch[next]) {
                ch[next] = true;
                DFS(next);
            }
        }
    }
}