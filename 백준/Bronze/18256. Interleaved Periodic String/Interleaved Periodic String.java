import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int s = 0;
            if (str.indexOf('0') != -1) s++;
            if (str.indexOf('1') != -1) s++;
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}