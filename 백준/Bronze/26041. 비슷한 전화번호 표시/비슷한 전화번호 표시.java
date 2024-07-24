import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[st.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }
        String str = br.readLine();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (str.length() < arr[i].length() && arr[i].startsWith(str)) count++;
        }
        System.out.println(count);
    }
}