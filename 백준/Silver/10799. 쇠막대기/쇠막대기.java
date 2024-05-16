import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\(\\)");
        int answer = 0;
        int s = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split[i].length(); j++) {
                if (split[i].charAt(j) == '(') s++;
                else {
                    s--;
                    answer++;
                }
            }
            answer += s;
        }
        System.out.println(answer);
    }
}