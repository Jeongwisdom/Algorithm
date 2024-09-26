import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int left = 0;
        int right = 0;
        int id = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') id++;
            if (str.charAt(i) == '@') {
                if (id == 0) left++;
                else right++;
            }
        }
        System.out.println(left + " " + right);
    }
}