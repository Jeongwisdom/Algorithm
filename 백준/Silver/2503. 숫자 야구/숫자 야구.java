import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[][] arr = new String[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = st.nextToken();
            }
        }
        System.out.println(check(arr));
    }
    
    public static int check(String[][] num) {
        int answer = 0;
        for (int i = 1; i <= 9; i++) {
            String s = String.valueOf(i);
            for (int j = 1; j <= 9; j++) {
                if (j == i) continue;
                String st = s + j;
                loop:
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) continue;
                    String str = st + k;
                    for (String[] strings : num) {
                        int strike = 0;
                        int ball = 0;
                        for (int m = 0; m < 3; m++) {
                            if (strings[0].charAt(m) == str.charAt(m))
                                strike++;
                            else if (str.contains(String.valueOf(strings[0].charAt(m))))
                                ball++;
                        }
                        if (strike != Integer.parseInt(strings[1]) || ball != Integer.parseInt(strings[2]))
                            continue loop;
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}