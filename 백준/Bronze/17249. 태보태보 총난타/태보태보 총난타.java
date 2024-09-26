import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split("\\^0\\^");
        int left = 0;
        int right = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < split[i].length(); j++) {
                if (split[i].charAt(j) == '@') {
                    if (i == 0) left++;
                    else right++;
                }
            }
        }
        System.out.println(left + " " + right);
    }
}