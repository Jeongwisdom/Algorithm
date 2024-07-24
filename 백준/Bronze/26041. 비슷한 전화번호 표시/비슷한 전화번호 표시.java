import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String str = br.readLine();
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            if (str.length() < split[i].length() && split[i].startsWith(str)) count++;
        }
        System.out.println(count);
    }
}