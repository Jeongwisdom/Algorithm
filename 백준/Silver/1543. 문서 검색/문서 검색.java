import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String word = br.readLine();
        int answer = 0;
        int id = sentence.indexOf(word);
        while (id != -1) {
            answer++;
            id = sentence.indexOf(word, id + word.length());
        }
        System.out.println(answer);
    }
}