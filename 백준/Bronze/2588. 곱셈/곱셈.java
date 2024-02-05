import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int num;
        int sum = 0;
        
        for (int i = 2, j = 0; i >= 0; i--, j++) {
            num = b.charAt(i) - '0';
            num *= a;
            sb.append(num)
                .append("\n");
            sum += num * Math.pow(10, j);
        }
        sb.append(sum);
        System.out.println(sb);
    }
}