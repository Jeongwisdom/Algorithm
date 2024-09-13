import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        int answer = split.length;
        if (answer != 0 && split[0].isBlank()) answer--;
        System.out.println(answer);
    }
}