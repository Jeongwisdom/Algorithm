import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = new char[n];
        int[] ch = new int[26];
        for (int i = 0; i < n; i++) {
            arr[i] = '?';
        }
        for (int i = 0; i < 26; i++) {
            ch[i] = -1;
        }
        int id = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            id = (id + num) % n;
            if ((arr[id] != '?' && arr[id] != c) || (ch[c - 'A'] != -1 && ch[c - 'A'] != id)) {
                id = -1;
                break;
            }
            arr[id] = c;
            ch[c - 'A'] = id;
        }
        StringBuilder sb = new StringBuilder();
        if (id == -1) sb.append("!");
        else {
            int count = 0;
            while (count++ < n) {
                sb.append(arr[id]);
                id--;
                if (id < 0) id = n - 1;
            }
        }
        System.out.println(sb);
    }
}