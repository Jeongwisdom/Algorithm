import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosion = br.readLine();
        int len = explosion.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= len && sb.substring(sb.length() - len).equals(explosion)) {
                sb.setLength(sb.length() - len);
            }
        }
        
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}