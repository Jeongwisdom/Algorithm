import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int num;
        if (str.length() % 3 == 1) {
            num = str.charAt(0) & 15;
            sb.append(num);
        } else if (str.length() % 3 == 2) {
            num = (str.charAt(0) & 15) * 2 + (str.charAt(1) & 15);
            sb.append(num);
        }
        for (int i = str.length() % 3; i < str.length(); i += 3) {
            num = (str.charAt(i) & 15) * 4 + (str.charAt(i + 1) & 15) * 2 + (str.charAt(i + 2) & 15);
            sb.append(num);
        }
        System.out.println(sb);
    }
}