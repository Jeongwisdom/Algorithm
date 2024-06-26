import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] arr, character;
    static int l, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        character = new char[l];
        DFS(0, 0, 0, 0);
        System.out.println(sb);
    }

    static void DFS(int count, int id, int consonant, int vowel) {
        if (count == l) {
            if (consonant >= 2 && vowel >= 1) {
                sb.append(character).append("\n");
            }
        } else if (id < c) {
            character[count] = arr[id];
            if (arr[id] == 'a' || arr[id] == 'e' || arr[id] == 'o' || arr[id] == 'i' || arr[id] == 'u') DFS(count + 1, id + 1, consonant, vowel + 1);
            else DFS(count + 1, id + 1, consonant + 1, vowel);
            DFS(count, id + 1, consonant, vowel);
        }
    }
}