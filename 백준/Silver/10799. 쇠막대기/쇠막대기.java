import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        int s = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') s++;
            else if (str.charAt(i) == ')' && str.charAt(i - 1) == '(') answer += --s;
            else {
                s--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}