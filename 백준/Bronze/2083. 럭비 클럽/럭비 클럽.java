import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split;
        while (true) {
            split = br.readLine().split(" ");
            if (split[0].charAt(0) == '#') break;
            sb.append(split[0]).append(" ");
            if (Integer.parseInt(split[1]) > 17 || Integer.parseInt(split[2]) >= 80) sb.append("Senior");
            else sb.append("Junior");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}