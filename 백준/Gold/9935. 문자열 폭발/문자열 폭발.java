import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] explosion = br.readLine().toCharArray();
        
        int answerId = 0, strId = 0, explosionLen = explosion.length;
        while (strId < str.length) {
            str[answerId++] = str[strId++];
            if (answerId >= explosionLen) {
                int i = 0;
                for (; i < explosionLen; i++) {
                    if (str[answerId - explosionLen + i] != explosion[i]) break;
                }
                if (i == explosionLen) answerId -= explosionLen;
            }
            
        }
        
        System.out.println((answerId == 0)? "FRULA": new String(str, 0, answerId));
    }
}