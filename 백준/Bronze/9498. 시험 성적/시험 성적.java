import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        if (score >= 90 && score <= 100) System.out.print("A");
        else if (score >= 80 && score <= 89) System.out.print("B");
        else if (score >= 70 && score <= 79) System.out.print("C");
        else if (score >= 60 && score <= 69) System.out.print("D");
        else System.out.print("F");
    }
}