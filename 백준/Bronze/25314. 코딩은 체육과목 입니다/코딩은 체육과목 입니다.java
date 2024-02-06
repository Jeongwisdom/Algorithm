import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("int");
        
        for (int i = 0; i < n / 4; i++) {
            sb.insert(0, "long ");
        }
        System.out.println(sb);
    }
}