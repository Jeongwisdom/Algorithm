import java.io.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c =System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[500001];
        for (int i = 0; i < n; i++) arr[read()]++;
        
        long answer = 0;
        int order = 1;
        for (int i = 0; i < 500001 && order <= n; i++) {
            while (arr[i]-- > 0) {
                answer += Math.abs(i - order++);
            }
        }
        System.out.println(answer);
    }
}