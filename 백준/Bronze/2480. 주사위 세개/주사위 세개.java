import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (a == b && b == c) answer = a * 1000 + 10000;
        else if (a == b || a == c) answer = a * 100 + 1000;
        else if (b == c) answer = b * 100 + 1000;
        else answer = Math.max(a, Math.max(b, c)) * 100;
        System.out.print(answer);
    }
}