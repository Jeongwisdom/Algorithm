import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s1 = br.readLine().length();
        int s2 = br.readLine().length();
        if (s1 >= s2) System.out.println("go");
        else System.out.println("no");
    }
}