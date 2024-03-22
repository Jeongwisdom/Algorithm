import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            int j = Integer.parseInt(st.nextToken());
            answer += j * j;
        }
        answer %= 10;
        System.out.println(answer);
    }
}