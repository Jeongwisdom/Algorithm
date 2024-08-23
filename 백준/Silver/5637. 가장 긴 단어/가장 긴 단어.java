import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;
        String answer = "";
        loop:
        while (true) {
            split = br.readLine().toLowerCase().replaceAll("[^a-z-]", " ").split(" ");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("e-n-d")) break loop;
                if (answer.length() < split[i].length()) answer = split[i];
            }
        }
        System.out.println(answer);
    }
}