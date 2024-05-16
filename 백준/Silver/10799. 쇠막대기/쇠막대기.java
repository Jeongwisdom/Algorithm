import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        int s = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') s++;
            else {
                s--;
                if (str.charAt(i - 1) == '(') answer += s;
                else answer++;
            }
        }
        System.out.println(answer);
    }
}