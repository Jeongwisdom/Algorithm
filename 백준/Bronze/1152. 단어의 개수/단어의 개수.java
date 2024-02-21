import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) answer++;
        }
        System.out.println(answer);
    }
}