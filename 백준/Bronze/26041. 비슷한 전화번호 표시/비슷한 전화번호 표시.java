import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        int count = 0;
        while (st.hasMoreTokens()) {
            String a = st.nextToken();
            if (str.length() < a.length() && a.startsWith(str)) count++;
        }
        System.out.println(count);
    }
}