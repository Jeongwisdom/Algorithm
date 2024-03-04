import java.util.*;
import java.io.*;

class Main {
    static boolean flag = false;
    static boolean[] ch = new boolean[9];
    static int[] arr = new int[9];
    static int[] answer = new int[2];
    static int total = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        
        Arrays.sort(arr);
        DFS(0, 0, new int[7]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i != answer[0] && i != answer[1]) sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    } 
    
    public static void DFS(int count, int sum, int[] a) {
        if (!flag) {
            if (count == 2) {
                if (total - sum == 100) {
                    answer = a.clone();
                    flag = true;
                }
            } else {
                for (int i = count; i < arr.length; i++) {
                    if (!ch[i]) {
                        ch[i] = true;
                        a[count] = i;
                        DFS(count + 1, sum + arr[i], a);
                        ch[i] = false;
                    }
                }
            }
        }
    }
}