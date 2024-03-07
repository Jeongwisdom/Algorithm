import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(check(arr));
    }
    
    public static int check(int[][] num) {
        int answer = 0;
        int[] arr = new int[3];
        for (int i = 1; i <= 9; i++) {
            arr[0] = i;
            for (int j = 1; j <= 9; j++) {
                if (j == i) continue;
                arr[1] = j;
                loop:
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) continue;
                    arr[2] = k;
                    for (int[] strings : num) {
                        String str = String.valueOf(strings[0]);
                        int strike = 0;
                        int ball = 0;
                        for (int m = 0; m < 3; m++) {
                            if (str.charAt(m) - '0' == arr[m])
                                strike++;
                            else {
                                for (int n = 0; n < 3; n++) {
                                    if (m != n && str.charAt(n) - '0' == arr[m]) {
                                        ball++;
                                    }
                                }
                            }
                        }
                        if (strike != strings[1] || ball != strings[2])
                            continue loop;
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}