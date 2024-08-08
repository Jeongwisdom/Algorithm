import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int b1 = Integer.parseInt(split[0]);
        int b2 = Integer.parseInt(split[1]);
        String answer = "No";
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            int lx = Integer.parseInt(split[0]);
            int ly = Integer.parseInt(split[1]);
            int hx = Integer.parseInt(split[2]);
            int hy = Integer.parseInt(split[3]);
            if (lx <= b1 && b1 <= hx && ly <= b2 && b2 <= hy) {
                answer = "Yes";
                break;
            }
        }
        System.out.println(answer);
    }
}