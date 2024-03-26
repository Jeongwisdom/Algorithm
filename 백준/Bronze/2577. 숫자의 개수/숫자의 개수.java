import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        int a = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        String ans = String.valueOf(a);
        for (int i = 0; i < ans.length(); i++) {
            num[ans.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(num[i]).append("\n");
        }
        System.out.println(sb);
    }
}