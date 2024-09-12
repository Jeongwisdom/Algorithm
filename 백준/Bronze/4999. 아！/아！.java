import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String answer;
        if (s1.length() >= s2.length()) answer = "go";
        else answer = "no";
        System.out.println(answer);
    }
}