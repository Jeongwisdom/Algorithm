import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int id = 0;
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max < num) {
                max = num;
                id = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(id);
        System.out.println(sb);
    }
}