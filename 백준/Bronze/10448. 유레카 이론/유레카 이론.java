import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[1001];
        int[] tri = new int[45];
        tri[0] = 1;
        for (int i = 1; i < 45; i++) {
            tri[i] = tri[i - 1] + (i + 1);
        }
        
        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j < tri.length; j++) {
                for (int k = 0; k < tri.length; k++) {
                    int sum = tri[i] + tri[j] + tri[k];
                    if (sum > 1000) break;
                    check[sum] = true;
                }
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            if (check[Integer.parseInt(br.readLine())]) bw.write("1");
            else bw.write("0");
            bw.write("\n");
        }
        bw.flush();
    }
}