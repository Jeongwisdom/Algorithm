import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            if (s == 0) {
                sb.append("0 0\n");
                continue;
            }
            
            boolean isMaxA;
            int max, min;
            if (a >= b) {
                isMaxA = true;
                max = a;
                min = b;
            } else {
                isMaxA = false;
                max = b;
                min = a;
            }
            
            int numA = 1000000001;
            int numB = 1000000001;
            int minus = 0;
            boolean[] remain = new boolean[max]; 
            while (s >= minus) {
                int re = (s - minus) % max;
                if (re == 0) {
                    if (isMaxA) {
                        numA = (s - minus) / max;
                        numB = minus / min;
                    } else {
                        numA = minus / min;
                        numB = (s - minus) / max;
                    }
                    break;
                } else {
                    if (remain[re]) break;
                    remain[re] = true;
                }
                minus += min;
            }
            if (numA == 1000000001 && numB == 1000000001) sb.append("Impossible\n");
            else sb.append(numA).append(" ").append(numB).append("\n");
        }
        System.out.println(sb);
    }
}