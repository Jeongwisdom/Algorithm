import java.io.*;
import java.util.*;

class Main {
    static int n, id = 0, answer = 0;
    static String[] arr;
    static char[] ch = new char[10];
    static int[] comb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            loop:
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);
                for (int k = 0; k < id; k++) {
                    if (ch[k] == c) continue loop;
                }
                ch[id++] = c;
            }
        }
        comb = new int[id];
        for (int i = 0; i < id; i++) comb[i] = -1;
        combination(0);
        System.out.println(answer);
    }
    
    static void combination(int count) {
        if (count == id) {
            DFS(0, 0);
            return;
        }
        for (int i = 0; i < id; i++) {
            if (comb[i] == -1) {
                comb[i] = 9 - count;
                combination(count + 1);
                comb[i] = -1;
            }
        }
    }
    
    static void DFS(int count, int sum) {
        if (count == n) {
            if (answer < sum) answer = sum;
            return;
        }
        int num = 0;
        for (int i = 0; i < arr[count].length(); i++) {
            char c = arr[count].charAt(i);
            for (int j = 0; j < id; j++) {
                if (c == ch[j]) {
                    num = num * 10 + comb[j];
                    break;
                }
            }
        }
        DFS(count + 1, sum + num);
    }
}