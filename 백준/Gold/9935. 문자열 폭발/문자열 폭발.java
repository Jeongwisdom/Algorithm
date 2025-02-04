import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosion = br.readLine();
        char[] answer = new char[str.length()];
        
        int answerId = 0, strId = 0, explosionLen = explosion.length();
        while (strId < str.length()) {
            answer[answerId++] = str.charAt(strId++);
            if (answerId >= explosionLen) {
                int i = 0;
                for (; i < explosionLen; i++) {
                    if (answer[answerId - explosionLen + i] != explosion.charAt(i)) break;
                }
                if (i == explosionLen) answerId -= explosionLen;
            }
            
        }
        
        System.out.println((answerId == 0)? "FRULA": new String(answer, 0, answerId));
    }
}