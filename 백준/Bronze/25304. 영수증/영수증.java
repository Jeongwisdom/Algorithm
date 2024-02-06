import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            total -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        if (total == 0) System.out.println("Yes");
        else System.out.println("No");
    }
}