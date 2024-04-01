import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 1) {
                sum += num;
                if (num < min) min = num;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n").append(min);
        if (sum == 0) System.out.println(-1);
        else System.out.println(sb);
    }
}