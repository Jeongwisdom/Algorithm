import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(divide(a, b, c));
    }
    
    public static long divide(int a, int b, int c) {
        if (b == 0) return 1;
        long answer = divide(a, b / 2, c);
        answer = answer * answer % c;
        if (b % 2 == 1) answer = answer * a % c;
        return answer;
    }
}