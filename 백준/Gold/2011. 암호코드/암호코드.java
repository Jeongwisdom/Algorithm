import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int answer = 0;
        if (code.charAt(0) != '0') {
            answer = -1;
            int[] dp = new int[code.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < code.length(); i++) {
                if (code.charAt(i) == '0') {
                    if (code.charAt(i - 1) == '1' || code.charAt(i - 1) == '2') {
                        dp[i + 1] = dp[i - 1];
                    } else {
                        answer = 0;
                        break;
                    }
                } else {
                    int num = (code.charAt(i - 1) - '0') * 10 + code.charAt(i) - '0';
                    if (num <= 26 && num >= 10) dp[i + 1] = (dp[i] + dp[i - 1]) % 1000000;
                    else dp[i + 1] = dp[i];
                }
            }
            if (answer == -1) answer = dp[code.length()];
        }
        System.out.println(answer);
    }
}