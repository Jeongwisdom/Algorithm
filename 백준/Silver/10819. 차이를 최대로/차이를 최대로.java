import java.io.*;
import java.util.*;

class Main {
    static int max = 0;
    static int n;
    static int[] arr;
    static int[] temp;
    static boolean[] ch;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        temp = new int[n];
        ch = new boolean[n];
        BF(0, 0);
        System.out.println(max);
    }
    
    public static void BF(int count, int sum) {
        if (count == n) {
            max = Math.max(max, sum);
        } else {
            for (int i = 0; i < n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    temp[count] = arr[i];
                    int num = 0;
                    if (count != 0) num = Math.abs(temp[count - 1] - temp[count]);
                    BF(count + 1, sum + num);
                    ch[i] = false;
                }
            }
        }
    }
}