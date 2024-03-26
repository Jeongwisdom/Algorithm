import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[10];
        int a = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        while (a > 0) {
            int n = a % 10;
            num[n]++;
            a /= 10;
        }
        for (int i = 0; i < 10; i++) {
            bw.write(num[i] + "\n");
        }
        bw.flush();
    }
}